package com.auth.user_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    @Autowired
    private final RoleService roleService;

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role FindById(@PathVariable Long id) {
        return roleService.FindById(id);
    }

    @PostMapping
    public Role CreateRole(@RequestBody @Validated Role role) {
        return roleService.CreateRole(role);
    }

    @PutMapping("/{id}")
    public Role UpdateRole(@PathVariable Long id ,@RequestBody @Validated Role role) {
        return roleService.UpdateRole(role);
    }

    @DeleteMapping("/{id}")
    public void DeleteRole(@PathVariable Long id) {
        roleService.DeleteRole(id);
    }
}
