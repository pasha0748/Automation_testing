package Lr3;

import entities.BaseClass;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ResponseHeader extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void Presence() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        boolean ContentSecurityPolicy = response.containsHeader("content-security-policy");
        if(ContentSecurityPolicy) System.out.println("content-security-policy exists");
        else System.out.println("content-security-policy doesn't exist");
    }

    @Test
    public void Value() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        Header ContentSecurityPolicy = response.getFirstHeader("content-security-policy");
        assertEquals(ContentSecurityPolicy.getValue(),"default-src 'none'");
    }
}
