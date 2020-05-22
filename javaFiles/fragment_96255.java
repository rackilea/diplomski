List<String> results = new ArrayList<>();
String s = "Hello, #how are you# today. Hello, #how are you #today.";
Pattern pattern = Pattern.compile("#\\b.*?\\b#|\\B#\\w+");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    results.add(matcher.group());
} 
System.out.println(results); 
// => [#how are you#, #how, #today]