String text = "test1 \"hello world!\" test2";

Pattern ptrn = Pattern.compile("\".*\"|([^\\W]+)");
Matcher m = ptrn.matcher(text);

while (m.find()) {
    if (m.group(1) != null) {
        System.out.println("Text: "+m.group(1));
    }
}