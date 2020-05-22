public static void test(String json) {
    try {
        validateJSON(json);
        System.out.println("Valid");
    } catch (Exception e) {
        System.out.println("Invalid: " + e);
    }
}