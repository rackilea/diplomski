public static Role fromId(long id) {
    if (1 == id) {
        return ADMINISTRATOR;
    }
    // TODO else if for the rest of enum instances
    } else {
        throw new AssertionError("Role not know!"); 
    }
}