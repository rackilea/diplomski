String string = "Name:armand,Age:22,";
    Pattern pattern = Pattern.compile("(\\w+?):(\\w+?),");
    Matcher matcher = pattern.matcher(string);
    while (matcher.find()) {
        String key = matcher.group(1);
        String value = matcher.group(2);

        System.out.println("Key : " + key + " value : " + value);
    }