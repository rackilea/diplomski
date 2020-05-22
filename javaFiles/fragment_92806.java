Matcher base = Pattern.compile("\\bred\\b|\\bgreen\\b|\\bblue\\b|[+()]{1}").matcher(input.trim());
while (!base.hitEnd()) {
   if (base.find()) {
      String s = base.group();
      System.out.println("Found: " + s);
      output += String.format(" %s", s);
   }
} 
if (output.isEmpty()) {
   throw new IllegalArgumentException("Invalid input no matching tokens found! " + base.toString());
}