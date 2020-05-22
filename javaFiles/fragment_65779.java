String input = "ggg;ggg;nnn;nnn;aaa;aaa;xxx;xxx;";
    Pattern p = Pattern.compile("([a-z]{3});\\1;");
    Matcher m = p.matcher(input);
    while (m.find())
        // m.group(0) is the result
        System.out.println(m.group(0));