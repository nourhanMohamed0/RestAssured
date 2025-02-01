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
}
