package org.example.tests;

import io.restassured.response.Response;
import org.example.api.UserAPI;
import org.example.base.BaseTest;
import org.example.models.request.CreateUserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    UserAPI userAPI = new UserAPI();

    @Test(groups = "smoke", description = "Verify get all users")
    public void testGetAllUsers() {
        Response response = userAPI.getAllUsers(2);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getList("data"));
        System.out.println("Total users: " + response.jsonPath().getList("data").size());
    }

    @Test(groups = "smoke", description = "Verify get single user")
    public void testGetSingleUser() {
        Response response = userAPI.getSingleUser(2);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
        System.out.println("User: " + response.jsonPath().getString("data.first_name"));
    }

    @Test(groups = "regression", description = "Verify user not found")
    public void testUserNotFound() {
        Response response = userAPI.getSingleUser(23);
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test(groups = "regression", description = "Verify create user")
    public void testCreateUser() {
        CreateUserRequest request = new CreateUserRequest("John Doe", "QA Engineer");
        Response response = userAPI.createUser(request);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        System.out.println("Created User ID: " + response.jsonPath().getString("id"));
    }

    @Test(groups = "regression", description = "Verify delete user")
    public void testDeleteUser() {
        Response response = userAPI.deleteUser(2);
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
