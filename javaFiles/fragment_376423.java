try (
        // Create input and output files
        Scanner input = new Scanner(sourceFile);
        PrintWriter output = new PrintWriter(targetFile);) {
    while (input.hasNext()) {
        String s1 = input.nextLine();
        String s2 = s1.replaceAll(args[2], args[3]);
        sb.append("\r\n" + s2);
    }
}
try (
        PrintWriter output = new PrintWriter(sourceFile);) {
    output.printf("%s\r\n", sb.toString());
}