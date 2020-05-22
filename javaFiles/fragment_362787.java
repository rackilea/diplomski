String s = "I want to run to get back on shape";
Pattern pattern = Pattern.compile("(?=\\bto\\b((?:\\s*[\\p{L}\\p{M}]+){4}))");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1).trim()); 
}