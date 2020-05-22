public static void main( String[] args ) {
    String toConvert = EXAMPLE_TEST;

    Pattern pattern = Pattern.compile("\\{\\w+\\}");
    // In case you would like to ignore case sensitivity you could use this
    // statement
    // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(toConvert);
    StringBuilder resultStringBuilder = new StringBuilder();
    int startPos = 0;
    while (matcher.find()) {

        // append everything up to this match.
        resultStringBuilder.append(toConvert.substring(startPos, matcher.start()));

        // append the replacement
        resultStringBuilder.append(lookup(matcher.group()));

        // set the start pos for the next match
        startPos = matcher.end();
    }
    // append everything that's left.
    resultStringBuilder.append(toConvert.substring(startPos, toConvert.length()));        


    String resultStrig = resultStringBuilder.toString();
    System.out.println(resultStrig);
}


private static String lookup( String s ) {
    // decide what you want to replace this string with
    // You might want to make use of a TreeMap<String,String> here.
    return "";
}