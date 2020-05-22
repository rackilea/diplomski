public static void main(String[] args) throws IOException {

  Set<String> legalEnglishWords = new HashSet<String>();
  Scanner file = new Scanner(new File("example.txt"));

  while (file.hasNextLine()) {
    String line = file.nextLine();

    for (String word : line.split(" ")) {
            legalEnglishWords.add(word);
        }
    }

    file.close();