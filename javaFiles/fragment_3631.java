public static void main(String[] args) {

    String str = "10 00,400,\"a1 b2 c3 \",zz xx,100, \"a b\"";
    StringBuffer sb = new StringBuffer();

    Matcher matcher = Pattern.compile("\"([^\"]+)\"").matcher(str);
    while (matcher.find()) {
        matcher.appendReplacement(sb, matcher.group().replaceAll("\\s+", ""));
    }

    System.out.println(sb.toString());
}