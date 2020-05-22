public static void main(String[] args) throws FileNotFoundException {
    findWords(new File("words.txt"));
}

public static void findWords(File file) throws FileNotFoundException {
    try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Enter the possible letters in your word: ");
        String lettersBeingTested = scan.next();
        System.out.println("Enter the number of letters in your target words: ");
        int numberOfLetters = scan.nextInt();
        int[] requiredHistogram = histogram(lettersBeingTested, new int[26]);

        Predicate<int[]> predicate = wordHistogram -> {
            for (int i = 0; i < requiredHistogram.length; i++)
                if (requiredHistogram[i] > 0 && wordHistogram[i] < requiredHistogram[i])
                    return false;
            return true;
        };

        Set<String> words = findWords(file, predicate, numberOfLetters);
        int i = 1;

        for (String word : words)
            System.out.println(i + " " + word);

        System.out.println("End of list: " + words.size() + " words found");
    }
}

private static int[] histogram(String str, int[] histogram) {
    Arrays.fill(histogram, 0);
    str = str.toLowerCase();

    for (int i = 0; i < str.length(); i++)
        histogram[str.charAt(i) - 'a']++;

    return histogram;
}

private static Set<String> findWords(File file, Predicate<int[]> predicate, int numberOfLetters) throws FileNotFoundException {
    try (Scanner scan = new Scanner(file)) {
        Set<String> words = new LinkedHashSet<>();
        int[] histogram = new int[26];

        while (scan.hasNext()) {
            String word = scan.next().toLowerCase();

            if (word.length() == numberOfLetters && predicate.test(histogram(word, histogram)))
                words.add(word);
        }

        return words;
    }
}