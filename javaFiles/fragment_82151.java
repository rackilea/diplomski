public static void appendToFile(File dir, String fileName) {
    try (FileWriter writer = new FileWriter(new File(dir, fileName), true)) {
        writer.write("Hello");
    } catch(IOException e) {
        e.printStackTrace();
    }
}