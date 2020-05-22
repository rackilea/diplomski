public static void main(String[] args) throws IOException {
    final Set<String> dictionary = loadDictionary();
    final String text = loadInput();
    final List<String> output = new ArrayList<>();
    // by default splits on whitespace
    final Scanner scanner = new Scanner(text);
    while(scanner.hasNext()) {
        final String token = scanner.next().toLowerCase();
        if (!dictionary.contains(token)) output.add(token);
    }
    System.out.println(output);

}

private static String loadInput() {
    return "This is a 5gse5qs sample f5qzd fbswx test";
}

private static Set<String> loadDictionary() throws IOException {
    final File dicFile = new File("path_to_your_flat_dic_file");
    final Set<String> dictionaryWords = new HashSet<>();
    String line;
    final LineNumberReader reader = new LineNumberReader(new BufferedReader(new InputStreamReader(new FileInputStream(dicFile), "UTF-8")));
    try {
        while ((line = reader.readLine()) != null) dictionaryWords.add(line);
        return dictionaryWords;
    }
    finally {
        reader.close();
    }
}