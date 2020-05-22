FileWriter writer = new FileWriter(output_file);

try (Stream<String> lines = Files.lines(Paths.get(input_file))) {
    lines.forEach(new Consumer<String>() {
        int i = 0;
        void accept(String line) {
            try {
                writer.write((i++) + " # " + line + System.lineSeparator());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    writer.close();
}