import entities.BaseClass;
import entities.NotFound;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class BodyTest extends BaseClass {
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
    public void returnCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/AsDeath");
        response = client.execute(get);

        User user = ResponseUtils.unmarshall(response,User.class);

        //int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println(user.getLogin());
        assertEquals(user.getLogin(), "AsDeath");
    }

    @Test
    public void returnCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/AsDeath");
        response = client.execute(get);

        User user = ResponseUtils.unmarshall(response,User.class);

        //int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println(user.getId());
        assertEquals(user.getId(), 52668348);
    }

    @Test
    public void returnCorrectLocation() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/AsDeath");
        response = client.execute(get);

        User user = ResponseUtils.unmarshall(response,User.class);

        //int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println(user.getLocation());
        assertEquals(user.getLocation(),"stray");
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/sdgvhtysvtyujynenbwvw");
        response = client.execute(get);

        NotFound notfound = ResponseUtils.unmarshallGeneric(response, NotFound.class);

        //int actualStatus = response.getStatusLine().getStatusCode();
        System.out.println(notfound.getMessage());
        assertEquals(notfound.getMessage(),"Not Found");
    }
}
