StringBuffer sb = new StringBuffer();
    Matcher m = Pattern.compile("\\d+").matcher(str);
    int n = 0;
    while(m.find()) {
        if (++n == 1) {
            m.appendReplacement(sb, "first");
        } else {
            m.appendReplacement(sb, "second");
        }
    }
    m.appendTail(sb);
    s = sb.toString();