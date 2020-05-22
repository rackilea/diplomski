List<String> linesList = null;  // Don't initialize here
String[] lines = fileContent.split("\n"); 

for(String line:lines){
    String[] splittedLine = line.split("\t");
    linesList = new ArrayList<String>(); // Initialize a new list everytime.

    for(String words:splittedLine){
        linesList.add(words);
    }
    lexiconContent.add(linesList); 
}