package org.example;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;


import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;

public class App
{
    public static void main( String[] args )
    {
        myFirstClass obj=new myFirstClass();
//        obj.getResponseBody();
//        obj.getStatusCode();
//        obj.getResponseHeaders();
//        obj.getResponseTime();
        obj.getSpecificPartOfResponseBody();
    }
}
