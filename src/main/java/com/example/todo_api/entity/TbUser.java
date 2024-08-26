package com.example.todo_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_user")
public class TbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = false)
    private String password;

    @Column(unique = false)
    private boolean enabled;

    @Column(unique = false)
    private String authority;
}
