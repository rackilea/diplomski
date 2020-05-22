String text =
        "12/34/56 date\n" +
        "1/23/45 another date\n";

    Pattern p = Pattern.compile("(?m)(?<=^\\d{1,2}/)\\d{1,2}");
    Matcher m = p.matcher(text);
    while (m.find()) {
        System.out.println(m.group());
    } // "34", "23"