package utils;

import org.testng.annotations.DataProvider;

public class TestData {
@DataProvider(name = "validCreateUserRequestBody")
    public Object[][] getValidCreateUserData(){
    return new Object[][]{
            {"[\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"username\": \"user1\",\n" +
                    "    \"firstName\": \"John\",\n" +
                    "    \"lastName\": \"Doe\",\n" +
                    "    \"email\": \"user1@example.com\",\n" +
                    "    \"password\": \"password123\",\n" +
                    "    \"phone\": \"1234567890\",\n" +
                    "    \"userStatus\": 1\n" +
                    "  }\n" +
                    "]"}
    };}
    @DataProvider(name = "getValidPlaceOrder")
    public Object[][] getValidPlaceOrder(){
    return new Object[][]{
            {"{\n" +
                    "  \"id\": 0,\n" +
                    "  \"petId\": 0,\n" +
                    "  \"quantity\": 0,\n" +
                    "  \"shipDate\": \"2025-02-03T17:42:56.901Z\",\n" +
                    "  \"status\": \"placed\",\n" +
                    "  \"complete\": true\n" +
                    "}"}
    };}
    @DataProvider(name = "invalidCreateUserRequestBody")
    public Object[][] getInValidCreateUserData(){
    return new Object[][]{
            {"[\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"username\": \"\",\n" +
                    "    \"firstName\": \"John\",\n" +
                    "    \"email\": \"user1@example.com\",\n" +
                    "    \"password\": \"password123\",\n" +
                    "    \"phone\": \"1234567890\",\n" +
                    "    \"userStatus\": 1\n" +
                    "  }\n" +
                    "]"}
    };
    }
    @DataProvider(name = "MissingFieldsBody")
    public Object[][] getMissingFieldsBody(){
    return new Object[][]{{"[\n" +
            "  {\n" +
            "    \"id\": 0,\n" +
            "    \"email\": \"user1@x.com\",\n" +
            "    \"password\": \"string\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]"}};
    }
    @DataProvider(name = "updatedBody")
    public Object[][] getUpdatedBody(){
    return new Object[][]{
            {"{\n" +
                    "  \"id\": 0,\n" +
                    "  \"username\": \"string\",\n" +
                    "  \"firstName\": \"string\",\n" +
                    "  \"lastName\": \"string\",\n" +
                    "  \"email\": \"string\",\n" +
                    "  \"password\": \"string\",\n" +
                    "  \"phone\": \"string\",\n" +
                    "  \"userStatus\": 0\n" +
                    "}"}
    };
    }
    @DataProvider(name = "invalidUpdatedBody")
    public Object[][] getInvalidUpdatedBody(){
    return new Object[][]{
            {"{\n" +
                    "  \"id\": 0,\n" +
                    "  \"username\": \"invalidUsername\",\n" +
                    "  \"firstName\": \"invalidFirstName\",\n" +
                    "  \"lastName\": \"invalidFirstName\",\n" +
                    "  \"email\": \"invalidEmail\",\n" +
                    "  \"password\": \"invalidPassword\",\n" +
                    "  \"phone\": \"invalidPhone\",\n" +
                    "  \"userStatus\": 0\n" +
                    "}"}
    };
    }
    @DataProvider(name = "invalidMailFormat")
    public Object[][] getInvalidMailFormat(){
    return new Object[][]{
            {"[\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"username\": \"user1\",\n" +
                    "    \"firstName\": \"John\",\n" +
                    "    \"lastName\": \"Doe\",\n" +
                    "    \"email\": \"user1.com\",\n" +
                    "    \"password\": \"password123\",\n" +
                    "    \"phone\": \"1234567890\",\n" +
                    "    \"userStatus\": 1\n" +
                    "  }\n" +
                    "]"}
    };
    }
    @DataProvider(name = "invalidDataTypeFormat")
    public Object[][] getInvalidDataTypeFormat(){
    return new Object[][]{
            {"[\n" +
                    "  {\n" +
                    "    \"id\": 'Helllo',\n" +
                    "    \"username\": \"user1\",\n" +
                    "    \"firstName\": 123,\n" +
                    "    \"lastName\": \"Doe\",\n" +
                    "    \"email\": \"user1.com\",\n" +
                    "    \"password\": \"password123\",\n" +
                    "    \"phone\": 01234567890,\n" +
                    "    \"userStatus\": 1\n" +
                    "  }\n" +
                    "]"}
    };
    }
    @DataProvider(name = "veryLongUserName")
    public Object[][] getVeryLongUserName(){
    return new Object[][]{{"Hello thereNHellHello thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhHello thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhQQQQQQQQQQQQQo thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhHello thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhQQQQQQQQQQQQQHello thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhHello thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhQQQQQQQQQQQQQEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhHello thereNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkNEw-YorkhQQQQQQQQQQQQQ"}};
    }


}
