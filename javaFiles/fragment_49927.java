List<String> names = new ArrayList<>();

while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.matches("^Name:.*")) {
        names.add(line.replaceAll("^Name:\\s+", ""));
    }
}