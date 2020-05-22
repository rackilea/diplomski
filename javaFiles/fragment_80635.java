Pattern p = Pattern
    .compile("\\(|\\)|\\\\[a-z]+");
Matcher m = p.matcher(text);
while(m.find()){
    System.out.println(m.group(0));
}