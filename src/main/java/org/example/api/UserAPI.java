package org.example.api;

import io.restassured.response.Response;
import org.example.constants.EndPoints;
import org.example.models.request.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserAPI {

    public Response getAllUsers(int page) {
        return given()
                .queryParam("page", page)
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then()
                .extract()
                .response();
    }

    public Response getSingleUser(int id) {
        return given()
                .pathParam("id", id)
                .when()
                .get(EndPoints.GET_SINGLE_USER)
                .then()
                .extract()
                .response();
    }

    public Response createUser(CreateUserRequest request) {
        return given()
                .body(request)
                .when()
                .post(EndPoints.CREATE_USER)
                .then()
                .extract()
                .response();
    }

    public Response deleteUser(int id) {
        return given()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_USER)
                .then()
                .extract()
                .response();
    }
}
