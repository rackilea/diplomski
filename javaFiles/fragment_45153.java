String example = "A= add(a,b,c,d)";
Pattern pattern = Pattern.compile("\\((.*)\\)");    
Matcher matcher = pattern.matcher(example);

while (matcher.find()) {
  System.out.println(matcher.group(1));
}