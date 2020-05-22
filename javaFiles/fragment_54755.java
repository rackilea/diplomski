try {
    for (String line : Files.readAllLines(Paths.get("C:\\path\\to\\text.txt"))) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}