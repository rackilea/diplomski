public static void main(String[] args) {

    String input = "(T(i-1).XX_1 + XY_8) + X + T(i-1).YY_2 * (ZY_14 + ZY_14) + T(i-1)";

    Pattern pattern = Pattern.compile("(\\w+\\([\\w-*+\\/]+\\).\\w+)|((?:(\\w+\\(.*?\\))))|(\\w+)");
    Matcher matcher = pattern.matcher(input);

    List<String> reslt = new ArrayList<>();
    while (matcher.find()) {//loop throw your matcher 
        if (matcher.group(1) != null) {
            reslt.add(matcher.group(1));
        }
//In your case you have to avoid this two groups 
//            if (matcher.group(2) != null) {
//                reslt.add(matcher.group(2));
//            }
//            if (matcher.group(3) != null) {
//                reslt.add(matcher.group(3));
//            }
        if (matcher.group(4) != null) {
            reslt.add(matcher.group(4));
        }
    }
    reslt.forEach(System.out::println);
}