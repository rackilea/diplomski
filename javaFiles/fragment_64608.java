public ArrayList<String> createConversionList(String primary, String secondary){
  //Determine which string is shorter.
  String shorter;
  String longer;
  boolean primaryIsShorter = false;
  if (primary.length() >= secondary.length()){
    longer = primary;
    shorter = secondary;
  } else{
    longer = secondary;
    shorter = primary;
    primaryIsShorter = true;
  }

  //Fills an array with all the character positions that differ between the
  //two strings, using the shorter string as the base.
  int[] posOfCharsToChange = new int[shorter.length()];
  for(int i = 0; i < shorter.length(); i++){
    if(shorter.charAt(i) != longer.charAt(i)){
      posOfCharsToChange[i] = i;
    } else{
      posOfCharsToChange[i] = -1;
    }
  }

  //Adds to an ArrayList all of the "Replace" strings.
  ArrayList<String> conversionList = new ArrayList();
  for(int pos: posOfCharsToChange){
    if(pos != -1){
      String s = "Replace " + secondary.charAt(pos) + " with " + primary.charAt(pos) + ". \n";
      conversionList.add(s);
    }
  }

  //Depending on which string was bigger, either adds "Add" or "Remove"
  //strings to the ArrayList. If the strings were the same size, does
  //nothing.
  if(primary.length() != secondary.length()){
    if(primaryIsShorter){
      for(int i = primary.length(); i < secondary.length(); i++){
        String s = "Remove " + secondary.charAt(i) + ". \n";
        conversionList.add(s);
      }
    }
    else{
      for(int i = secondary.length(); i < primary.length(); i++){
        String s = "Add " + primary.charAt(i) + ". \n";
        conversionList.add(s);
      }
    }
  }

  return conversionList;
}