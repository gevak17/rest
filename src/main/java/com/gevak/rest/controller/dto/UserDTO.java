package com.gevak.rest.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gevak.rest.entity.User;

public class UserDTO {

    @JsonProperty("user_id")
    Long userId;
    @JsonProperty("username")
    public String username;
    @JsonProperty("password")
    public String password;
    @JsonProperty("email")
    public String email;
    @JsonProperty("phone1")
    public String phone1;
    @JsonProperty("phone2")
    public String phone2;
    @JsonProperty("phone3")
    public String phone3;
    @JsonProperty("name")
    public String name;
    @JsonProperty("rate")
    public Float rate;

    public UserDTO(){}

    public UserDTO(String username, String password, String email, String phone1,
                   String phone2, String phone3, String name, Float rate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.name = name;
        this.rate = rate;
    }

    public UserDTO(String username, String password, String email) {

    }
}
