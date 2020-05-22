Pattern p = Pattern
            .compile("(\\d{4}-\\d{2}-\\d{2})\\s*(\\d{2}:\\d{2})?(:\\d{2})?\\s*(\\+|-\\d{4})?");
    String[] strs = { "2010-11-02 10:46:05 -0600", "2010-11-02 10:46:05",
            "2010-11-02 10:46", "2010-11-02", "2010-11-02 -0600" };
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss Z");
    for (String s : strs) {
        Matcher m = p.matcher(s);
        if (m.matches()) {
            String hrmin = m.group(2) == null ? "00:00" : m.group(2);
            String sec = m.group(3) == null ? ":00" : m.group(3);
            String z = m.group(4) == null ? "+0000" : m.group(4);
            String t = String.format("%s %s%s %s", m.group(1), hrmin, sec,
                    z);
            System.out.println(s + " : " + format.parse(t));
        }
    }