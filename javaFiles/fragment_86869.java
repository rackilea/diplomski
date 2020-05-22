String regex_script = "\\[([^\\]]*)\\]";

    String line = "This is a[WAIT] testThis is a[WAIT] test";
    StringBuffer sb = new StringBuffer();
    List<String> list = new ArrayList<String>();   //use to record

    Pattern p = Pattern.compile(regex_script); // Create a pattern to match
    Matcher m = p.matcher(line); // Create a matcher with an input string

    while (m.find()) {
        list.add(m.group(1));
        m.appendReplacement(sb, "[^]");
    }
    m.appendTail(sb); // Add the last segment of input to the new String

    System.out.println(sb.toString());