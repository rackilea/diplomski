while ((currentLine = reader.readLine()) != null){
    currentLine = currentLine.trim();
    String[] wordList = currentLine.split("\\s+");
    String result =wordList[wordList.length-1];
    writer.write(result);    //write to file straight
}