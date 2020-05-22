//"": Unused to-search strings, so the matcher objects can be reused.
Matcher intMatch = Pattern.compile("^\\d+").matcher("");
Matcher opMatch = Pattern.compile("^[-+*/()]+").matcher("");

String expression = "23*12+11";

while ( ! expression.isEmpty()) {
   System.out.println("New expression: " + expression);

   intMatch.reset(expression);
   opMatch.reset(expression);

   if(intMatch.find()) {
      ...