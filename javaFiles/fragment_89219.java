List<String> words = new ArrayList<>();
Scanner input = new Scanner(System.in);
for (int i = 0; input.hasNextLine(); i++) {
    String line = input.nextLine();
    words.add(line);
    if (line.equalsIgnoreCase("exit")) {
        break;
    }
}
System.out.println(words);
return words;