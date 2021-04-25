package entities;

public class User {

    //For tests using JsonObject
    public static final String LOGIN = "login";
    public static final String ID = "id";
    public static final String BLOG = "blog";
    public static final String LOCATION = "location";

    private String login;
    private int id;
    private String blog;
    private String location;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getBlog() {
        return blog;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
