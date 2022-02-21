package com.student.tests;

import com.student.utils.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class TestBase {

    public static PropertyReader prop;

    @BeforeClass

    public static void initUrl() {

        prop = PropertyReader.getInstance();

        RestAssured.baseURI = prop.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(prop.getProperty("port"));

    }
}
