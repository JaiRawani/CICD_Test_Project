package org.example.tests;

import io.restassured.response.Response;
import org.example.api.LoginAPI;
import org.example.base.BaseTest;
import org.example.models.request.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginAPI loginAPI = new LoginAPI();

    @Test(groups = "smoke", description = "Verify successful login")
    public void testLoginSuccess() {
        LoginRequest request = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        Response response = loginAPI.login(request);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("token"));
        System.out.println("Token: " + response.jsonPath().getString("token"));
    }

    @Test(groups = "regression", description = "Verify login with wrong password")
    public void testLoginFailure() {
        LoginRequest request = new LoginRequest("eve.holt@reqres.in", "wrongpassword");
        Response response = loginAPI.login(request);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response: " + response.getBody().asString());
    }
}
