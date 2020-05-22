public static void main(String[] args) {
    String test2 = "";
    try {
        int test = Integer.parseInt("123");
        test2 = "ABCD";
    } catch (NumberFormatException ex) {
        System.out.print(ex.getMessage());
    }
}