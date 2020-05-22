Pattern p = Pattern.compile("<([^\\s>/]+)");
    Matcher m = p.matcher(txt);
    while(m.find()) {
        String tag = m.group(1);
        System.out.println(tag);
    }