public static Role fromString(String string) {
    switch (string) {
        case "manager": return Manager;
        case "customer": return Customer;
    }
    throw new IllegalArgumentException("Invalid role: " + string);
}