public Shortener( String inAbbreviationsFilePath ) throws FileNotFoundException {

   Scanner s = new Scanner(new File(inAbbreviationsFilePath));
   ArrayList<String> list = new ArrayList<String>(); 

   while (s.hasNext()) {
      //HERE
      String line = s.next();
      String[] lineSplit = line.split(","); //split into two tokens
      list.add(lineSplit[0]); //word
      list.add(lineSplit[1]); //number
   }

    abbreviations = list.toArray(new String[list.size()]);
    s.close(); 
}