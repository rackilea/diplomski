public class DnaMatcher {

    static boolean isSearchChar(char c) {
        return 'A' == c || 'T' == c || 'G' == c || 'C' == c;
    }

    static Pattern preparePattern(String searchSequence) {
        StringBuilder pattern = new StringBuilder();
        boolean first = false;
        for (char c : searchSequence.toCharArray()) {
            if (isSearchChar(c)) {
                if (first) {
                    first = false;
                } else {
                    pattern.append(".*");
                }
                pattern.append(c);
            }
        }
        return Pattern.compile(pattern.toString());
    }

    static boolean contains(String sequence, String searchSequence) {
        Pattern pattern = preparePattern(searchSequence);
        Matcher matcher = pattern.matcher(sequence);
        return matcher.find();
    }

    public static void main(String...none) throws Exception {
        System.out.println(contains("CTyyGCACA", "TxxAA")); // true
        System.out.println(contains("TCCCA", "TAA")); // false
    }
}