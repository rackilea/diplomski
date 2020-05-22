public static void main(String[] args) {
    String[] input = { "Hello, World!", "aaaaaaaaaaaa" };
    String[] output = { "1112111121311", "123456789101112" };
    for (int i = 0; i < input.length; i++) {
        String result = numericals(input[i]);
        System.out.printf("%s %b%n", result, result.equals(output[i]));
    }
}