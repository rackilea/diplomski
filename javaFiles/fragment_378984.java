public String replaceForSemicolons(String input) {
    String pattern = "for\\s*\\([^;]+;[^;]+[^\\)]+\\)\\s*\\{";
    Pattern reg = Pattern.compile(pattern);
    Matcher matcher = reg.matcher(input);
    StringBuffer output = new StringBuffer();
    int previousEnd = 0;

    while(matcher.find()) {
        //get the matched 'for' without the opening bracket
        String matchedString = input.substring(matcher.start(), matcher.end()-1);
        //replace the semicolons with @
        matchedString = matchedString.replaceAll(";", "@");
        //append everything from the end of the last match to the start of this match
        output.append(input.substring(previousEnd, matcher.start()));
        //append the matched string with the replaced semicolons
        output.append(matchedString);
        //add a new line and the opening bracket that we left out from the matched string
        output.append("\n{");
        previousEnd = matcher.end();
    }

    //append the rest of the string
    output.append(input.substring(previousEnd));

    return output.toString();
}