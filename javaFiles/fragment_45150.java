ArrayList<String> dictionary = new ArrayList<>();

private void onLoad() throws FileNotFoundException, IOException {
    long start2 = System.nanoTime();

    try (BufferedReader input = new BufferedReader(new FileReader("C:/A_WORDS/dictionary.txt"))) {
        for (String line = input.readLine(); line != null; line = input.readLine())
            dictionary.add(line);

        input.close();
    }