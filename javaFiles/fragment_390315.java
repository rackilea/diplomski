BufferedReader br = new BufferedReader(new FileReader(file));
 String line;
 while ((line = br.readLine()) != null) {
  if (line.contains("Complete Population"){
    // do something
    break; // breaks the while loop
  }
 }

 // we reached the section with numbers
 while ((line = br.readLine()) != null) {
    // use String.split to split the line, then convert 
    //the values to double and process them.  
 }