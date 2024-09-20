package com.auth.user_management;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Set;

@Table(name = "roles")
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String display_name;

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(name = "role_permissions"
    //         , joinColumns = @JoinColumn(name = "role_id")
    //         , inverseJoinColumns = @JoinColumn(name = "permission_id"))

    // private Set<Permission> permissions;
}
