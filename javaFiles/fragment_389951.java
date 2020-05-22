public static void main(String[] args) {
    String test ="((6.28 + 3.14) + 7.56)";
    String re = "\\(|\\)|\\d+\\.?\\d*|[+-/%^!*]";

    List<String> components = new ArrayList<String>();

    Pattern p = Pattern.compile(re);
    Matcher m = p.matcher(test);

    while(m.find()) {
        components.add(m.group());
    }

    System.out.println(components);
}