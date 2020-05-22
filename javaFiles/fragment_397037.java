public static void main(String[] args) throws IOException {
    // load the dictionary into a set for fast lookups
    Set<String> dictionary = new HashSet<String>();
    Scanner filescan = new Scanner(new File("dictionary.txt"));
    while (filescan.hasNext()) {
        dictionary.add(filescan.nextLine().toLowerCase());
    }

    // scan for input
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String input = scan.next().toLowerCase();
    System.out.println();

    // place to store list of results, each result is a list of strings
    List<List<String>> results = new ArrayList<>();

    long time = System.currentTimeMillis();

    // start the search, pass empty stack to represent words found so far
    search(input, dictionary, new Stack<String>(), results);

    time = System.currentTimeMillis() - time;

    // list the results found
    for (List<String> result : results) {
        for (String word : result) {
            System.out.print(word + " ");
        }
        System.out.println("(" + result.size() + " words)");
    }
    System.out.println();
    System.out.println("Took " + time + "ms");
}

public static void search(String input, Set<String> dictionary,
        Stack<String> words, List<List<String>> results) {

    for (int i = 0; i < input.length(); i++) {
        // take the first i characters of the input and see if it is a word
        String substring = input.substring(0, i + 1);

        if (dictionary.contains(substring)) {
            // the beginning of the input matches a word, store on stack
            words.push(substring);

            if (i == input.length() - 1) {
                // there's no input left, copy the words stack to results
                results.add(new ArrayList<String>(words));
            } else {
                // there's more input left, search the remaining part
                search(input.substring(i + 1), dictionary, words, results);
            }

            // pop the matched word back off so we can move onto the next i
            words.pop();
        }
    }
}