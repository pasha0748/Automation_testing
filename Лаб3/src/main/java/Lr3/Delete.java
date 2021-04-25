package Lr3;

import entities.BaseClass;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Delete extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;
    String mytoken = "FakeToken";
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
    public void deleteRepository() throws IOException {
        HttpDelete request = new HttpDelete(BASE_ENDPOINT+"/repos/AsDeath/deleteme");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token "+mytoken);

        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(actualStatusCode, 204);
    }
}
