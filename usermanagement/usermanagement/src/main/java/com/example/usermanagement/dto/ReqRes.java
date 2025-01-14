package com.example.usermanagement.dto;

import java.util.List;

import com.example.usermanagement.entity.OurUsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String role;
    private String name;
    private String email;
    private String city;
    private String password;
    private OurUsers ourUsers;
    private List<OurUsers> ourUsersList;
}
