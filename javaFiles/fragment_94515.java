public static void main(String[] args) throws Exception {
    // Prints a number, up to 10 characters right justified
    System.out.println(String.format("%10d", 123456));

    // Prints a number, up to 10 characters left justified
    System.out.println(String.format("%-10d", 123456));

    System.out.println(String.format("%10s", "12345"));
    System.out.println(String.format("%-10s", "12345"));

    // Still prints all characters, but since it exceeds the expected 10 characters it's just printed
    System.out.println(String.format("%10s", "123456789101112"));
}