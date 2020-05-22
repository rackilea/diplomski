// store unique previous words
static Set<String> words = new HashSet<>();

static String removeDuplicateWords(String line) {
    StringJoiner sj = new StringJoiner(" ");
    // split on whitespace to get distinct words
    for (String word : line.split("\\s+")) {
        // try to add word to the set
        if (words.add(word)) {
            // if the word was added (=not seen before), append to the result
            sj.add(word);
        }
    }
    return sj.toString();
}