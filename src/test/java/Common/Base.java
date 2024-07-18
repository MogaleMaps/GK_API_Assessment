package Common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;


public class Base {

    protected static String accessToken;
    static TestData data = new TestData();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = data.URI;
        accessToken = getAccessToken();
    }

    public static String getAccessToken() {
        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "a6e0c4b730c84b7f9f8c3533c324f611")
                .formParam("client_secret", "6e9d444cf0944d71beed612d1915d051")
                .post("/api/token");

        return response.jsonPath().getString("access_token");
    }
}
