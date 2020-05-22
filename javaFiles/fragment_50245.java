class MyWriter {
    void write(String input, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.close();
        }
    }
}