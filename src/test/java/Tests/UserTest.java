package Tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseTest {
    String createUserEndpoint = "/user/createWithList";
    String UserEndpoint = "/user/";

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

    @Test(dataProvider = "MissingFieldsBody",dataProviderClass = utils.TestData.class)
    public void TC_CreateUser_MissingFields(String missingBodyField){
        given().contentType(ContentType.JSON)
                .body(missingBodyField)
                .when()
                .post(createUserEndpoint)
                .then()
                .statusCode(400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void checkFunctionality(){
     Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"user1");
     System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test(dataProvider = "validCreateUserRequestBody",dataProviderClass = utils.TestData.class,dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_addExistingUser(String existingRequestBody){
        given().contentType(ContentType.JSON)
                .when()
                .post(createUserEndpoint)
                .then()
                .statusCode(400);

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
                .get(UserEndpoint + nonExistingUser)
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
                .get(UserEndpoint + "user1")
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
                .get(UserEndpoint + "@#  #$%")
                .then()
                .assertThat()
                .statusCode(400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void validateUserSchemas(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"user1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("utils/schemas/userSchema.json"));
    }

    @Test
    public void TC_getUser_NotFound(){
        given().contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"UserNotFoundAtAll")
                .then()
                .statusCode(404);
    }
    @Test
    public void TC_getUser_NoParameter(){
        given().contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint)
                .then()
                .statusCode(400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid",dataProviderClass = utils.TestData.class,dataProvider = "validCreateUserRequestBody")
    public void TC_CheckResponseBody_getUser(String as) {
        Response response=given().contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"user1");
       String expectedBody=as.replaceAll("\\s","");
       String actualBody=(response.body().asString()).replaceAll("\\s","");
        Assert.assertEquals(expectedBody.replaceAll("^\\[|\\]$",""),actualBody);
    }
@Test(dependsOnMethods = "TC_CreateUser_Valid",dataProviderClass = utils.TestData.class,dataProvider = "validCreateUserRequestBody")
    public void TC_CheckSpaceValidation_getUser(String as) {
        Response response=given().contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"        user1          ");
       String expectedBody=as.replaceAll("\\s","");
       String actualBody=(response.body().asString()).replaceAll("\\s","");
        Assert.assertEquals(expectedBody.replaceAll("^\\[|\\]$",""),actualBody);
    }
    @Test(dataProvider = "updatedBody",dataProviderClass = utils.TestData.class)
    public void TC_CheckSuccessfulUpdate_putUser(String updatedBody){
        Response response=given().
                contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put(UserEndpoint+"user1");
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test(dataProvider = "invalidUpdatedBody",dataProviderClass = utils.TestData.class)
    public void TC_CheckInvalidBodyStatusCode_putUser(String invalidUpdatedBody){
        Response response=given().
                contentType(ContentType.JSON)
                .body(invalidUpdatedBody)
                .when()
                .put(UserEndpoint+"user1");
        Assert.assertEquals(response.statusCode(),400);
    }
    @Test(dataProvider = "updatedBody",dataProviderClass = utils.TestData.class)
    public void TC_CheckNotFoundUserStatusCode_putUser(String updatedBody){
        Response response=given().
                contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put(UserEndpoint+"NotFoundUser");
        Assert.assertEquals(response.statusCode(),404);
    }

    @Test(dataProvider = "updatedBody",dataProviderClass = utils.TestData.class)
    public void TC_CheckWrongMethodStatusCode_putUser(String updatedBody){
        Response response=given().
                contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .post(UserEndpoint+"NotFoundUser");
        Assert.assertEquals(response.statusCode(),405);
    }
    @Test(dataProvider = "MissingFieldsBody",dataProviderClass = utils.TestData.class,dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckMissingFieldsStatusCode_putUser(String MissingFieldsBody){
        Response response=given().
                contentType(ContentType.JSON)
                .body(MissingFieldsBody)
                .when()
                .post(UserEndpoint+"user1");
        Assert.assertEquals(response.statusCode(),405);
    }
    @Test(dataProvider = "invalidMailFormat",dataProviderClass = utils.TestData.class,dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckInvalidMailFormatStatusCode_putUser(String invalidMailFormatBody){
        Response response=given().
                contentType(ContentType.JSON)
                .body(invalidMailFormatBody)
                .when()
                .post(UserEndpoint+"user1");
        Assert.assertEquals(response.statusCode(),400);
    }
    @Test(dataProvider = "invalidDataTypeFormat",dataProviderClass = utils.TestData.class,dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckInvalidDataTypeFormatStatusCode_putUser(String invalidDataTypeFormat){
        Response response=given().
                contentType(ContentType.JSON)
                .body(invalidDataTypeFormat)
                .when()
                .put(UserEndpoint+"user1");
        Assert.assertEquals(response.statusCode(),400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckMissingBody_putUser(){
        Response response=given().
                contentType(ContentType.JSON)
                .body("{}")
                .when()
                .put(UserEndpoint+"user1");
        Assert.assertEquals(response.statusCode(),400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckDeleteUserSuccessfully_deleteUser(){
        given().
                contentType(ContentType.JSON)
                .when()
                .delete(UserEndpoint+"user1");
        given().contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"user1")
                .then()
                .assertThat().statusCode(404);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckDeleteNotExistingUser_deleteUser(){
        given().
                contentType(ContentType.JSON)
                .when()
                .delete(UserEndpoint+"NotExistingUser")
                .then()
                .assertThat().statusCode(404);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid",dataProviderClass = utils.TestData.class,dataProvider = "veryLongUserName")
    public void TC_CheckDeleteVeryLongUser_deleteUser(String veryLongUserName){
        given().
                contentType(ContentType.JSON)
                .when()
                .delete(UserEndpoint+veryLongUserName)
                .then()
                .assertThat().statusCode(414);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckSuccessfulLoginUser(){
        given().
                contentType(ContentType.JSON)
                .when()
                .queryParam("username","user1")
                .queryParam("password","password123")
                .get(UserEndpoint+"login")
                .then()
                .assertThat().statusCode(200);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckInvalidUsernameLoginUser(){
        given().
                contentType(ContentType.JSON)
                .when()
                .queryParam("username","notLoggedIn")
                .queryParam("password","password123")
                .get(UserEndpoint+"login")
                .then()
                .assertThat().statusCode(400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckInvalidPasswordLoginUser(){
        given().
                contentType(ContentType.JSON)
                .when()
                .queryParam("username","user1")
                .queryParam("password","NotValidPassword")
                .get(UserEndpoint+"login")
                .then()
                .assertThat().statusCode(400);
    }
    @Test(dependsOnMethods = "TC_CreateUser_Valid")
    public void TC_CheckSuccessfulLogoutUser(){
        given().
                contentType(ContentType.JSON)
                .when()
                .get(UserEndpoint+"logout")
                .then()
                .assertThat().statusCode(200);
    }


}
