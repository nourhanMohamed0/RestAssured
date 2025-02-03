package Tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StoreTest extends BaseTest {
    String placeOrderEndpoint="/store/order";
    @BeforeClass
    public void setUp(){
        System.out.println("Hello from Store API Testing");
    }
    @Test(dataProvider = "getValidPlaceOrder",dataProviderClass = utils.TestData.class)
    public void TC_checkSuccessfulPlaceOrder(String placeValidBody){
        given()
                .body(placeValidBody)
                .contentType(ContentType.JSON)
                .when()
                .then()
                .statusCode(200);
    }

}
