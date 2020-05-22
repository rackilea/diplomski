public static void main(String[] args) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt").getAbsoluteFile()))) {
        for (String sCurrentLine: Files.readAllLines(Paths.get("input.txt"))) {
            String[] splitted = sCurrentLine.split("=");
            if (splitted.length > 1) {
                for (int i = 1; i < splitted.length; i++) {
                    bw.write(splitted[i].split("\\s+")[0] + "\n");
                }
            }
        }
    }
}