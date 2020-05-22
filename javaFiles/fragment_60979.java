ProcessBuilder builder = new ProcessBuilder("java",  "-jar", "MMM\\NNN LLL\\OOO\\AAA\\BBB\\CCC\\ZZZ.jar");
try {
    builder.start();
} catch (IOException e) {
    e.printStackTrace();
}