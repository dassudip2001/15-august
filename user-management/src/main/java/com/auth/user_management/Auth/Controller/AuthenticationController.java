package com.auth.user_management.Auth.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.user_management.Auth.DTO.LoginUserDto;
import com.auth.user_management.Auth.DTO.RegisterUserDto;
import com.auth.user_management.Auth.Entity.CustomUser;
import com.auth.user_management.Auth.JWT.JwtService;
import com.auth.user_management.Auth.Response.LoginResponse;
import com.auth.user_management.Auth.Services.AuthenticationService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomUser> register(@RequestBody RegisterUserDto registerUserDto) {
        CustomUser registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        CustomUser authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());


        return ResponseEntity.ok(loginResponse);
    }
}
