String text = "some text here 'quoted text here' some more text";
String regex = "'(.*?)'";
Pattern pattern = Pattern.compile(regex);
Matcher m = pattern.matcher(text);
if (m.find()){
        String s = m.group(1);
        System.out.println(s);
}