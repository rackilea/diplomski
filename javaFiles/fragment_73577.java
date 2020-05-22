class RemoveNegated {
    public static String removeAllNegated(String s, List<String> list) {
        StringBuilder result = new StringBuilder();
        // Move along the string from the front
        while (s.length() > 0) {
            boolean match = false;
            // Try matching a pattern
            for (String p : list) {
                // If the pattern is matched
                if (s.toLowerCase().startsWith(p.toLowerCase())) {
                    // Save it
                    result.append(p);
                    // Move along the string
                    s = s.substring(p.length());
                    // Signal a match
                    match = true;
                        break;
                    }
                }
                // If there was no match, move along the string
                if (!match) {
                s = s.substring(1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abcxyzorkdefaef";
        s = removeAllNegated(s, Arrays.asList("abc", "def", "ghi"));
        System.out.println(s);
    }
}