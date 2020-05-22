try (PrintWriter fileout = new PrintWriter("./src/javaapplication1/test.dat")) {
    for (int i = 0; i < 10; i++) {
        fileout.println(i);
    }
} catch (IOException e) {
    // Don't just swallow the exception - use that information!
    System.out.println("Error writing file: " + e);
}