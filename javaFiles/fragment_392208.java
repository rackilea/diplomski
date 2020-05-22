Scanner scanner = new Scanner(filename);
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    for (String word : line.split(" ")) {
        data.add(word);
    }
}