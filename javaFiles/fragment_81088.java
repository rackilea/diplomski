public static void main(String[] args) throws Exception {
    final String[] test = {"Lorem ipsum REF964-758362-562",
        "Lorem ipsum ABCD964-758362-562 lorem ipsum",
        "REF964-758362-562 Lorem ipsum 1234-123456-22",
        "Lorem ipsum 964-758362-562 lorem ipsum",
        "REF964758362562",
        "REF964-758362-562",
        "964-758362562",
        "964758362-562",
        "964758362562",
        "964-758362-562"};
    final Pattern patt = Pattern.compile("(?>REF)?(\\d{3}+)(-?)(\\d{6}+)\\2(\\d{3}+)");
    final MessageFormat format = new MessageFormat("{0}-{1}-{2}");
    for (final String in : test) {
        final Matcher mat = patt.matcher(in);
        while (mat.find()) {
            final String id = format.format(new Object[]{mat.group(1), mat.group(3), mat.group(4)});
            System.out.println(id);
        }
    }
}