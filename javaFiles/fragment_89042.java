// TODO: Put the imports at the top of the class
// This is done once, just like creating the regex above:
java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);

// The following is done for every user input:
java.util.regex.Matcher matcher = pattern.matcher(userInputTestCase);
java.util.List<String> results = new java.util.ArrayList<>();
while(matcher.find()){
  results.add(matcher.group());
}
System.out.println(userInputTestCase + " → " + results);