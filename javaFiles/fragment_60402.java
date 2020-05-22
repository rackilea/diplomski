Pattern pattern = Pattern.compile("(\\d+)");
    Matcher matcher = pattern.matcher(line1);
    if (matcher.find())
    {
        String digits = matcher.group();
        int num = Integer.parseInt(digits);
    }