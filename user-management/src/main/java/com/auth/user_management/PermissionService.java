package com.auth.user_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    @Autowired
    private final PermissionRepository permissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Permission FindById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    public Permission CreatePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission UpdatePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void DeletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
