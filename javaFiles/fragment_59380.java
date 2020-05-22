ArrayList<String> author = ...
String needle = ...

// Collect matches
List<Integer> matchingIndices = new ArrayList<>();
for (int i = 0; i < author.size(); i++) {
    String element = author.get(i);

    if (needle.equals(element)) {
        matchingIndices.add(i);
    }
}

// Print matches
matchingIndices.forEach(System.out::println);