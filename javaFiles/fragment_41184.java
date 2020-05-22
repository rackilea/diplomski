Map<String, Integer> countDfIndex = new HashMap<String, Integer>();

for (... document : documents) {
    Set<String> alreadyAdded = new HashSet<String>(); // new empty set for each document

    ...

    if (!alreadyAdded.contains(word)) {
        if (!countDfIndex.containsKey(word) {
            countDfIndex.put(word, 1);
        } else {
            countDfIndex.put(word, countDfIndex.get(word) + 1);
        }
        alreadyAdded.add(word); // don't add the word anymore if found again in the document
    }

}