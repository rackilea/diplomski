Map<String,String> hrefs = new HashMap<String,String>();
    hrefs.put("[1,2]", "one-two");
    hrefs.put("[3,4]", "three-four");
    hrefs.put("[5,6]", "five-six");

    String text = "p [1,2] \nq [3,4] \nr [5,6] \ns";

    Matcher m = Pattern.compile("\\[[^\\[\\]]*\\]").matcher(text);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
        String section = m.group(0);
        String url = String.format("<a href='%s'>%s</a>",
            hrefs.get(section),
            section
        );
        m.appendReplacement(sb, url);
    }
    m.appendTail(sb);

    System.out.println(sb.toString());