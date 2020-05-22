public static void main(String[] args) {
    String str = "2 someword 3 word anotherword: 7, 5";
    Pattern pattern = Pattern.compile("(\\w+) (\\w+:) (\\d+), (\\d+)");

    Matcher matcher = pattern.matcher(str);

    while(matcher.find()) {
        String word = matcher.group(1);
        String anotherword = matcher.group(2);
        String str7 = matcher.group(3);
        String str5 = matcher.group(4);
        System.out.println(word+" "+anotherword+" "+str7+" "+str5);
    }
}