package restApi.Test;

import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AccountTest {

    @Test
    public void UnauthorizedAccess() {
        given().when().get("/accounts").then().statusCode(401);
    }

    @Test
    public void AuthorizedAccess() {
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
}
