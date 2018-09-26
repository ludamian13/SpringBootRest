package restApi.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

public class AccountTest {

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

    @Test
    public void unauthorizedAccess() {
        given().when().get("/accounts").then().statusCode(401);
    }

    @Test
    public void authorizedAccess() {
        given()
                .auth().basic("john123", "password")
                .expect()
                .statusCode(200)
                .when()
                .get("/accounts");
    }

    @Test
    public void verifyStreetExistence() {
        given().auth().basic("john123", "password").when().get("/accounts").then()
                .body(containsString("city"));
    }

    @Test
    public void createAccountTest() {
        given().auth().basic("john123", "password")
                .queryParam("name", "name8")
                .queryParam("email", "email8")
                .queryParam("street", "street8")
                .queryParam("city", "city8")
                .queryParam("state", "state8")
                .when().put("/account").then()
                .statusCode(200);
    }

    @Test
    public void verifyGetUserWithANonExistentId() {
        given().auth().basic("john123", "password")
                .queryParam("accountId", "-1")
                .when().get("/account").then()
                .body(containsString("No account found"));
    }
}
