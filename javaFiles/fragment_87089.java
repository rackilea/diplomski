Path path = Paths.get("buttons.txt");
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
for (String line : lines) {
    String[] words = line.split(";\\s*");
    if (words.length > 2 && words[0].equals("button")) {
        JButton button = new JButton(word[1]);
        button.addActionListener(this); ...
        ... add(button);
        buttons.add(button);
    }
}