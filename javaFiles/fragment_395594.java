public static void main(String[] args) {
    String str = "street address Santa Maria and another st. lohberg and give me another av. darrwerg and another st street";
    Pattern p = Pattern.compile("((address|st\\.|av\\.)\\s)(\\w+?\\s)");
    Matcher m = p.matcher(str);
    List<String> streets = new ArrayList<String>();
    while (m.find()) {
        streets.add(m.group(3));
    }
    System.out.println(streets);
}