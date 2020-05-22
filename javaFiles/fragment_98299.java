String name = "John David Guetta MarkHenry Anthoney Sam";
Pattern p = Pattern.compile(".{1,30}(\\s+|$)");
Matcher m = p.matcher(name);
while(m.find()) {
  System.out.println(m.group().trim());
}