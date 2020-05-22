public static String[] extractNouns(String sentenceWithTags) {
    // Split String into array of Strings whenever there is a tag that starts with "._NN"
    // followed by zero, one or two more letters (like "_NNP", "_NNPS", or "_NNS")
    String[] nouns = sentenceWithTags.split("_NN\\w?\\w?\\b");
    // remove all but last word (which is the noun) in every String in the array
    for(int index = 0; index < nouns.length; index++) {
        nouns[index] = nouns[index].substring(nouns[index].lastIndexOf(" ") + 1)
        // Remove all non-word characters from extracted Nouns
        .replaceAll("[^\\p{L}\\p{Nd}]", "");
    }
    return nouns;
}