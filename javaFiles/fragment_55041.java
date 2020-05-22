public static void main(){
    String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    Pattern pattern = Pattern.compile("(?=(aaa))");
    Matcher matcher = pattern.matcher(input);
    List<Integer> all = new ArrayList<>();
    while (matcher.find()) {
        all.add(matcher.start());
    }
    System.out.println(all);
}