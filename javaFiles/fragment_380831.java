public List<String> splitBySize(String s, int length) {
    List<String> splits = new ArrayList();
    if (s != null && !s.isEmpty()) {
        int startIndex = 0;
        int endIndex = length;

        while (endIndex < s.length()) {
            if (s.charAt(endIndex) != ' ') {
                endIndex = s.lastIndexOf(' ', endIndex);
                // if endIndex <= startIndex -> strategy?
            }
            splits.add(s.substring(startIndex, endIndex));
            startIndex = endIndex;
            endIndex = startIndex + length;
        }
        // add last part
        splits.add(s.substring(startIndex));
    }
    return splits;
}