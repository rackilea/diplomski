public class NaturalLanguageMath {

    public static void main(String[] args) {
        String sentence = "Four plus Ten divided by (fifty-five plus nine)";
        System.out.println(toMath(sentence));
    }

    // Regular expression that will match our symbols
    // special case for "divided by" since that's two words for one symbol
    static final Pattern SYMBOL_PATTERN = Pattern.compile("(divided by|[a-z-]+)", Pattern.CASE_INSENSITIVE);

    private static String toMath(String sentence) {
        // Builder to build the translated string
        StringBuilder builder = new StringBuilder();
        // End of the last matched group
        int lastEnd = 0;
        // Go through all symbols in the string
        Matcher matcher = SYMBOL_PATTERN.matcher(sentence);
        while(matcher.find()) {
            // The matched symbol
            String symbol = matcher.group(0).toLowerCase();
            // Get the replacement
            String replacement = getReplacement(symbol);
            // Append everything between the previous match and this match
            builder.append(sentence.substring(lastEnd, matcher.start()));
            // Append the replacement
            builder.append(replacement);
            // Update the end
            lastEnd = matcher.end();
        }
        // Append the end of the string and return it
        builder.append(sentence.substring(lastEnd));
        return builder.toString();
    }

    // Map to hold replacement symbols
    static final HashMap<String, String> REPLACEMENT_MAP = new HashMap<>();
    static {
        REPLACEMENT_MAP.put("four", "4");
        REPLACEMENT_MAP.put("plus", "+");
        REPLACEMENT_MAP.put("ten", "10");
        REPLACEMENT_MAP.put("fifty", "50");
        REPLACEMENT_MAP.put("five", "5");
        REPLACEMENT_MAP.put("nine", "9");
        REPLACEMENT_MAP.put("divided by", "/");
    }

    private static String getReplacement(String symbol) {
        // Handle compounds such as fifty-five
        if(symbol.contains("-")) {
            // add each individual symbol together and return the result
            // this is far from perfect since it will allow compounds such as
            // fifty-five-nine which would become 64
            int value = 0;
            // Go through each individual symbol and translate it
            String[] symbols = symbol.split("-");
            for(String s : symbols) {
                if(!REPLACEMENT_MAP.containsKey(s)) {
                    throw new IllegalArgumentException("Unknown symbol: " + s);
                }
                value += Integer.parseInt(getReplacement(s));
            }
            return String.valueOf(value);
        // Straight translation
        } else if (REPLACEMENT_MAP.containsKey(symbol)) {
            return REPLACEMENT_MAP.get(symbol);
        // Unknown symbol
        } else {
            throw new IllegalArgumentException("Unknown symbol: " + symbol);
        }
    }
}