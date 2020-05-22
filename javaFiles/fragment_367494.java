Pattern regex = Pattern.compile("From \"(.*)\" to \"(.*)\"\\.");
    Matcher matcher = regex.matcher("From \"A\" to \"B\".");
    if(matcher.find())
    {
        String a = matcher.group(1);
        String b = matcher.group(2);
        return new String[]{a,b};
    }