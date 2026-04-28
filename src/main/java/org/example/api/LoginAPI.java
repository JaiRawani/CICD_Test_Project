package org.example.api;

import io.restassured.response.Response;
import org.example.constants.EndPoints;
import org.example.models.request.LoginRequest;

import static io.restassured.RestAssured.given;

public class LoginAPI {

    public Response login(LoginRequest request) {
        return given()
                .body(request)
                .when()
                .post(EndPoints.LOGIN)
                .then()
                .extract()
                .response();
    }

    public Response loginWithInvalidCredentials(LoginRequest request) {
        return given()
                .body(request)
                .when()
                .post(EndPoints.LOGIN)
                .then()
                .extract()
                .response();
    }
}
