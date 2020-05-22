package com.example.role;

public final class Roles {
    private static Collection<Role> values = Collections.unmodifiableList(Arrays.asList(
        UserRole.getInstance(),
        CustomerRole.getInstance(),
        ProductOwnerRole.getInstance(),
        CustomerAdminRole.getInstance(),
        UserManagerRole.getInstance(),
        AdminRole.getInstance()));

    private Roles() {
    }

    public static Collection<Role> values() {
        return values;
    }

    // Other methods...
}