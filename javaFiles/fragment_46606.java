String[] testValues = { "123", "123.4", "FALSE", "false",
        "some strings" };

for (String test : testValues) {
    Scanner scanner = new Scanner(test);
    scanner.useDelimiter("^");
    if (scanner.hasNextBoolean()) {
        boolean value = scanner.nextBoolean();
        System.out.println("boolean " + value);
    } else if (scanner.hasNextDouble()) {
        double value = scanner.nextDouble();
        System.out.println("number " + value);
    } else if (scanner.hasNext(".*")) {
        String value = scanner.next();
        System.out.println("string " + value);
    }
}