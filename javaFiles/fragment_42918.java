Pattern pattern = Pattern.compile("\\[.*\\]");
    Matcher matcher = pattern.matcher(json);
    if (matcher.find())
    {
        System.out.println(matcher.group());
    }