static List<List<String>> substrings(String input) {

    // Base case: There's only one way to split up a single character
    // string, and that is ["x"] where x is the character.
    if (input.length() == 1)
        return Collections.singletonList(Collections.singletonList(input));

    // To hold the result
    List<List<String>> result = new ArrayList<>();

    // Recurse (since you tagged the question with recursion ;)
    for (List<String> subresult : substrings(input.substring(1))) {

        // Case: Don't split
        List<String> l2 = new ArrayList<>(subresult);
        l2.set(0, input.charAt(0) + l2.get(0));
        result.add(l2);

        // Case: Split
        List<String> l = new ArrayList<>(subresult);
        l.add(0, input.substring(0, 1));
        result.add(l);
    }

    return result;
}