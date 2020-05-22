// the read document
String document = "Document Name\n" +
    "1. Question one:\n" +
    "a. Answer one to question one\n" +
    "b. Answer two to question one\n" +
    "c. Answer three to question one\n" +
    "2. Question two:\n" +
    "a. Answer one to question two\n" +
    "c. Answer two to question two\n" +
    "e. Answer three to question two";

// splitting by lines
String[] lines = document.split("\r?\n");

// the regex patterns
Pattern questionPattern = Pattern.compile("\\d{1,2}\\..+");
Pattern answerPattern = Pattern.compile("[a-z]\\..+");

// intermediate holding variable
String lastLine = null;

// the result    
Map<String, List<String>> result = new HashMap<>();

for(int lineNumber = 0; lineNumber < lines.length; lineNumber++){
    String line = lines[lineNumber];

    if(questionPattern.matcher(line).matches()){
        result.put(line, new LinkedList<>());
        lastLine = line;
    } else if(answerPattern.matcher(line).matches()){
        result.get(lastLine).add(line);
    } else{
        System.out.printf("Line %s is not a question nor an answer!%n", lineNumber);
    }
}