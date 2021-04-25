package Lr3;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.BaseClass;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Post extends BaseClass {
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
    public void createRepository() throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT+"/user/repos");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token "+mytoken);

        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"name\":\"deleteme\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(actualStatusCode, 201);
    }

}
