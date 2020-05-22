BufferedReader reader =  new BufferedReader(new   FileReader(path));
String line;
boolean isWordFound = false;
while ((line = reader.readLine()) != null)        {  

    // add the line in the list if the word was found       
    if (isWordFound()){
      sensor_Daten.add(line);
    }

    // flag isWordFound to true when the match is done the first time
    if (!isWordFound && line.matches(myRegex)){
      isWordFound = true;
    } 
}