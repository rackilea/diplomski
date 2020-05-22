String s = "500 Robin Stuart    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
Pattern p = Pattern.compile("(\t)(.*?)(\t)");
Matcher m1 = p.matcher(s);
if (m1.find()){
    System.out.println(m1.group(2));
}