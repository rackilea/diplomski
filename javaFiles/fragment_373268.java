package com.example.role;

public class UserRole extends Role {
    private static final UserRole instance = new UserRole();

    private UserRole() {
        super("ROLE_user", 1);
    }

    public UserRole getInstance() {
        return instance;
    }
}