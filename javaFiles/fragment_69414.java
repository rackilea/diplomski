public static ArrayList<String> parseArguments(String argument){
    Pattern regex = Pattern.compile("^\\s*([AHG4-9])\\s*(\\d)?\\s*$",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    Matcher regexMatcher = regex.matcher(argument);

    if (regexMatcher.find()) {

        ArrayList<String> arguments = new ArrayList<String>();

        arguments.add(regexMatcher.group(1));

        if(regexMatcher.group(2) != null)
        {
            arguments.add(regexMatcher.group(2));
        }

        return arguments;
    }

    return null;

}