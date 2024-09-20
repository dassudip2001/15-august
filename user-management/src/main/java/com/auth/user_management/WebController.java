package com.auth.user_management;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {

    @RequestMapping("/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello() {
        return "Hello World";
    }
}
