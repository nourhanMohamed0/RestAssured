package Tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseTest {
    String createUserEndpoint = "/user/createWithList";
    String getUserEndpoint = "/user/";

    @BeforeClass
    public void setUp() {
        System.out.println("Hello from User API Testing");
    }

    @Test(dataProvider = "validCreateUserRequestBody",dataProviderClass = utils.TestData.class)
    public void TC_CreateUser_Valid(String validRequestBody) {
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
        Response response=RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(validRequestBody)
                .when()
                .post(createUserEndpoint);
        long responseTime=response.getTime();
        System.out.println("Response Time is "+responseTime);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void checkFunctionality(){
     Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .get(getUserEndpoint+"user1");
     System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);

    }
    @Test
    public void TC_ValidateStatusCodeMissedBodyCreateUser(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .post(createUserEndpoint)
                .then()
                .statusCode(400);
    }

    @Test(dataProvider = "invalidCreateUserRequestBody",dataProviderClass = utils.TestData.class)
    public void TC_CreateUser_Invalid(String invalidRequestBody) {
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
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void validateUserSchemas(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(getUserEndpoint+"user1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("utils/schemas/userSchema.json"));
    }/////////////////////////////////////////////////utils/schemas/userSchema.json

}
