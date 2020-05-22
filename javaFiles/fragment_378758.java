String p = "(.+)\\s(ab|cd|efg)";

    Pattern pattern = Pattern.compile(p,Pattern.DOTALL);

    String str = "xyz ab";

    Matcher m = pattern.matcher(str);

    if (m.find()) { 
        System.out.println(m.group(1));
        System.out.println(m.group(2));
    }