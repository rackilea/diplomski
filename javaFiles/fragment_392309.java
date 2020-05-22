String text =type1.first().html();
String[] textSplitResult = text.split("<br>");
if (null != textSplitResult) {
    Arrays.stream(textSplitResult).peek((x) -> System.out.println(x)).count();
    //or Arrays.stream(textSplitResult).peek(System.out::println).count();
}