String str = "<blockquote>1. тест </blockquote><blockquote>2. 1) ветка; метрика </blockquote>";

Pattern pattern1 = Pattern.compile("(тест)|(ветка;)|(метрика)");

Matcher matcher = pattern1.matcher(str);
while (matcher.find()) {
    System.out.print("Start index: " + matcher.start());
    System.out.print(" End index: " + matcher.end() + " ");
    System.out.println(matcher.group());
}