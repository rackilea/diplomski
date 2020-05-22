ArrayList<String> resultList = new ArrayList<String>();
...

while ((currentLine = reader.readLine()) != null){
    currentLine = currentLine.trim();
    String[] wordList = currentLine.split("\\s+");
    resultList.add(wordList[wordList.length-1]);    //add to a list
}

...

//Perform your writing 
for(String s : resultList)
    writer.write(s);