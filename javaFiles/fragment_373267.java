package com.example.role;

public abstract class Role {
    private int rank;
    private String value;

    Role(String value, int rank) {
        this.value = value;
        this.rank = rank;
    }

    // Other methods...
}