private static List<String> substrings(int i, String input) {
    List<String> result = new ArrayList<String>();
    if (i == 0)
        return result;

    String first = input.substring(0, i);
    result.add(first);

    if (input.length() == i) {
        return result;
    }

    // Recursively find substrings of next smaller length not including the first character
    List<String> tails = substrings(i-1, input.substring(1));

    // Append first char to each result of the recursive call.
    for (String sub: tails) {
        String s = input.substring(0, 1) + sub;
        if (!(result.contains(s)))
            result.add(s);
    }

    // Add all substring of current length not including first character
    result.addAll(substrings(i, input.substring(1)));
    return result;
}