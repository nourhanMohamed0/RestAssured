package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.JsonUtil;
import workshops.api.User;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {
    String baseURI = "https://petstore.swagger.io/v2";
    String createUserEndpoint = "/user/createWithList";
    String getUserEndpoint = "/user/";

    String validRequestBody = "[{\"id\":1,\"username\":\"user1\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"user1@example.com\",\"password\":\"password123\",\"phone\":\"1234567890\",\"userStatus\":1}]";
    String invalidRequestBody = "[{\"id\":1,\"username\":\"\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"user1@example.com\",\"password\":\"password123\",\"phone\":\"1234567890\",\"userStatus\":1}]";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void TC_CreateUser_Valid() {
        given()
                .contentType(ContentType.JSON)
                .body(validRequestBody)
                .when()
                .post(createUserEndpoint)
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("ok"));
    }

    @Test
    public void TC_CreateUser_Invalid() {
        given()
                .contentType(ContentType.JSON)
                .body(invalidRequestBody)
                .when()
                .post(createUserEndpoint)
                .then()
                .statusCode(400); // Update to match expected behavior
    }

    @Test
    public void TC_GetUser_NonExisting() {
        String nonExistingUser = "nonExistingUser";
        given()
                .when()
                .get(getUserEndpoint + nonExistingUser)
                .then()
                .statusCode(404)
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("User not found"));
    }

    @Test
    public void TC_HeadersValidation() {
        given()
                .when()
                .get(getUserEndpoint + "user1")
                .then()
                .assertThat()
                .headers("access-control-allow-headers", equalTo("Content-Type,api_key,Authorization"),
                        "access-control-allow-origin", equalTo("*"),
                        "content-type", equalTo("application/json"));
    }
    @Test
    public void TC_InvalidUsernameValidation() {
        given()
                .when()
                .get(getUserEndpoint + "@#  #$%")
                .then()
                .assertThat()
                .statusCode(400);
    }
    @Test
    public void test() throws IOException {
        User user= JsonUtil.readJsonFromFile("src/test/testData/user/user.json", User.class);
    }
}
