package Tests;

import Common.Base;
import Common.TestData;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class SpotifyTests extends Base {
    Response response;
    TestData data = new TestData();

    @BeforeClass
    public static void setup() {
           Base.setUp();
    }

    @Test
    @Description("As an API user, I would like to retrieve all albums on my spotify account")
    public void getAlbum() {
        System.out.println(accessToken);
        response = given()
                .header("Authorization", "Bearer " + accessToken)
                .get(data.URI +"/v1/albums/4aawyAB9vmqN3uQ7FjRGTy")
                .then().
                log().all().
                assertThat().statusCode(200).
                extract().response();
    }
}
