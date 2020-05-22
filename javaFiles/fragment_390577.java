public static int findNthIndexOf (String str, String needle, int occurence)
            throws IndexOutOfBoundsException {
    int index = -1;
    Pattern p = Pattern.compile(needle, Pattern.MULTILINE);
    Matcher m = p.matcher(str);
    while(m.find()) {
        if (--occurence == 0) {
            index = m.start();
            break;
        }
    }
    if (index < 0) throw new IndexOutOfBoundsException();
    return index;
}