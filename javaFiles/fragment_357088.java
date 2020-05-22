public List<String> getQuotet(final String input, final char quote) {
    final ArrayList<String> result = new ArrayList<>();
    int n = -1;
    for(int i = 0; i < input.length(); i++) {
        if(input.charAt(i) == quote) {
            if(n == -1) { //not currently inside quote -> start new quote
                n = i + 1;
            } else { //close current quote
                result.add(input.substring(n, i));
                n = -1;
            }
        }
    }
    return result;
}