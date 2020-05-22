static List<String> getWords(String fileName) {
    List<String> al = new ArrayList<>();
    File file = new File(fileName);
    try (Scanner scanner = new Scanner(file);) {
        while (scanner.hasNext()) {
            String line = scanner.next();
            al.add(line);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return al;
}

static final List<String> words = getWords("word_list.txt");