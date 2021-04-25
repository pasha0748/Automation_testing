package Lr3;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.BaseClass;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ResponseBody extends BaseClass {
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
    public void returnCorrectLogin() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/apple");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        User user = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonBody,User.class);
        assertEquals(user.getLogin(),"apple");
    }

    @Test
    public void returnCorrectId() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/apple");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        User user = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonBody,User.class);
        assertEquals(user.getId(),10639145);
    }

    @Test
    public void returnCorrectBlog() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/apple");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        User user = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonBody,User.class);
        assertEquals(user.getBlog(),"https://apple.com");
    }

    @Test
    public void returnCorrectLocation() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/apple");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        User user = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonBody,User.class);
        assertEquals(user.getLocation(),"Cupertino, CA");
    }

    @Test
    public void readData() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/apple");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        User user = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonBody,User.class);

        System.out.println(user);
    }

    @Test
    public void writeData() throws JsonGenerationException, JsonMappingException, IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/apple");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        User user = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(jsonBody,User.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("user1.json"),user);
    }
}
