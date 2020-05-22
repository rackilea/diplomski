private static String add(String num1, String num2) {
    // implement
}

private static String multiply(String num1, String num2) {
    // implement
}

try (
    BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
) {
    String num1, num2;
    while ((num1 = reader.readLine()) != null) {
        num2 = reader.readLine();       // assumes your input is formatted correctly
        num1.replaceAll(",", "");       // "delete" commas
        num2.replaceAll(",", "");
        System.out.printf("%s\n", num1);
        System.out.printf("%s\n", num2);
        System.out.printf("sum: %s\n",     add(num1, num2));
        System.out.printf("product: %s\n", multiply(num1, num2)); 
        reader.readLine();              // consume blank line
    }
} catch (IOException e) {
    System.err.println(e.getMessage()); // error output
}