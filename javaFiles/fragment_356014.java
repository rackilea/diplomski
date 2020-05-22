public static void main(String[] args) {
    String string = "[{1000, 500, 1}, {1001, 501, 1}, {1002, 501, 2}]";
    Matcher m = Pattern.compile("\\{[0-9, ]+\\}").matcher(string);
    while(m.find()){
        System.out.println(m.group());
    }
}