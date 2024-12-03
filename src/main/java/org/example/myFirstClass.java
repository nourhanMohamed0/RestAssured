package org.example;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class myFirstClass {
    String URL="http://demo.guru99.com/V4/sinkministatement.php";
    public void getResponseBody(){
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
//        given().queryParam("CUSTOMER_ID","68195")
//                .queryParam("PASSWORD","1234!")
//                .queryParam("Account_No","1")
//                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
//                .all();
    }
    public void getStatusCode(){
        int statusCode=given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1").when()
                .get("http://demo.guru99.com/V4/sinkministatement.php").statusCode();
        System.out.println("Status code is "+statusCode);
    }
    public void getResponseHeaders(){
        System.out.println("The Headers in the response are "+given()
                .queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1").when()
                .get(URL).then().extract().headers());

    }
    public void getResponseTime(){
        System.out.println("The Time taken to fetch a response is "+get(URL).timeIn(TimeUnit.MILLISECONDS)+" MS");
    }
    public void getSpecificPartOfResponseBody(){
        ArrayList <String> amounts=
    when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().extract().path("result.statements.AMOUNT");
        int sumAll=0;
        for(String amount:amounts){
            sumAll+=Integer.valueOf(amount);
        }
        System.out.println("The sum of all the amounts is "+sumAll);
    }

    }


