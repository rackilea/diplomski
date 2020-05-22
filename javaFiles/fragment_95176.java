String s = "o_9,o_8,x_7,o_6,o_5";
    Pattern p = Pattern.compile("\\w+");
    Matcher m = p.matcher(s);
    while (m.find()) {
        String matchedWord = m.group();
        System.out.println("Matched \"" + matchedWord + "\".");
    }