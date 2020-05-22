Pattern p = Pattern.compile("(\\d{1,2})");
    Matcher m = p.matcher("12 54 1 65");
    StringBuffer s = new StringBuffer();
    while (m.find())
        m.appendReplacement(s, String.valueOf(3 * Integer.parseInt(m.group(1))));
    System.out.println(s.toString());