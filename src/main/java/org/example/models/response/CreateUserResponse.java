package org.example.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;

    public String getName() { return name; }
    public String getJob() { return job; }
    public String getId() { return id; }
    public String getCreatedAt() { return createdAt; }
}
