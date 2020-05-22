public static void main(String[] args) throws Exception {
    List<String> values = new ArrayList<String>();
    values.add("AB");
    values.add("A012B");
    values.add("CD");
    values.add("1");
    values.add("10");
    values.add("01");
    values.add("9");

    int maxLen = 0;
    for (String string : values) {
        if (string.length() > maxLen) {
            maxLen = string.length();
        }
    }

    Collections.sort(values, new MyComparator(maxLen));

    System.out.println(values);
}

public static class MyComparator implements Comparator<String> {
    private int maxLen;
    private static final String REGEX = "[0-9]+";

    public MyComparator(int maxLen) {
        this.maxLen = maxLen;

    }

    @Override
    public int compare(String obj1, String obj2) {
        String o1 = obj1;
        String o2 = obj2;
        // both numbers
        if (o1.matches("[1-9]+") && o2.matches("[1-9]+")) {
            Integer integer1 = Integer.valueOf(o1);
            Integer integer2 = Integer.valueOf(o2);
            return integer1.compareTo(integer2);
        }

        // both string
        if (o1.matches("[a-zA-Z]+") && o2.matches("[a-zA-Z]+")) {
            return o1.compareTo(o2);
        }

        Pattern p = Pattern.compile(REGEX);
        Matcher m1 = p.matcher(o1);
        Matcher m2 = p.matcher(o2);

        List<String> list = new ArrayList<String>();
        while (m1.find()) {
            list.add(m1.group());
        }
        for (String string : list) {
            o1.replaceFirst(string, leftPad(string, "0", maxLen));
        }

        list.clear();

        while (m2.find()) {
            list.add(m2.group());
        }
        for (String string : list) {
            o2.replaceFirst(string, leftPad(string, "0", maxLen));
        }
        return o1.compareTo(o2);

    }
}

public static String leftPad(String stringToPad, String padder, Integer size) {

    final StringBuilder strb = new StringBuilder(size.intValue());
    final StringCharacterIterator sci = new StringCharacterIterator(padder);

    while (strb.length() < (size.intValue() - stringToPad.length())) {
        for (char ch = sci.first(); ch != CharacterIterator.DONE; ch = sci.next()) {
            if (strb.length() < (size.intValue() - stringToPad.length())) {
                strb.insert(strb.length(), String.valueOf(ch));
            }
        }
    }

    return strb.append(stringToPad).toString();
}