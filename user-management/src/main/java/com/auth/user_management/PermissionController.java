package com.auth.user_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {
    @Autowired
    private final PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> findAll() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity< Permission> FindById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.FindById(id));
    }

    @PostMapping
    public ResponseEntity< Permission> CreatePermission(@RequestBody @Validated Permission permission) {
        return ResponseEntity.ok(permissionService.CreatePermission(permission));
    }

    @PutMapping("/{id}")
    public Permission UpdatePermission(@PathVariable Long id ,@RequestBody @Validated Permission permission) {
        return permissionService.UpdatePermission(permission);
    }

    @DeleteMapping("/{id}")
    public void DeletePermission(@PathVariable Long id) {
        permissionService.DeletePermission(id);
    }

}
