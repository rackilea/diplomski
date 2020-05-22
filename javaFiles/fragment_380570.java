String temp = "";
 for(String w:words) {
  // this will override temp only if the word is longer
  if ( w.length() > temp.length() ) {
    temp = w;
  }
 }
 // don't print harcoded "temp", but concatenate the value of the variable temp
 System.out.println("The longest word is: " + temp);