public static void main(String[] args) {
    String regex = "^(?=([\\D]?\\d){10,13}$)(?!.*--)(?!\\+-)\\+?[-0-9]*";

    String[] passes = { "+12345-12446-123", "123456-1-789", "123456789-0-1-2-3" };
    for (String string : passes)
        if (!string.matches(regex))
            System.out.println("should pass: " + string);

    String[] fails = { "123+435-1244", "123456--789", "+-123123123", "123", "11111-1-1-1-1-1-1111111111"};
    for (String string : fails)
        if (string.matches(regex))
            System.out.println("should fail: " + string);
}