package org.example.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.config.ConfigReader;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeSuite
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getBaseUrl())
                .setBasePath(ConfigReader.getBasePath())
                .setContentType(ContentType.JSON)
                .addHeader("x-api-key", ConfigReader.getApiKey())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RestAssured.requestSpecification = requestSpec;
    }
}
