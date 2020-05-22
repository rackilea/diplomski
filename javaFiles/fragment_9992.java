String s = "a'a'a'a a' a'a-'bb";
String parts[] = s.split("[ -]");
for(String i:parts) {
    if(!i.isEmpty())
    {
    System.out.println(i + " => " + i.matches("[a-zA-Z]+(?:'[a-zA-Z]+)*"));
}
}