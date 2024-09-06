package com.auth.user_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role FindById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role CreateRole(Role role) {
        return roleRepository.save(role);
    }

    public Role UpdateRole(Role role) {
        return roleRepository.save(role);
    }

    public void DeleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
