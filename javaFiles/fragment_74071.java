String str = "This is a string";
String[] strArray = str.split(" ");   //splits at all instances of the space & stores in array
for (int i = 0; i < strArray.length(); i++) {
  if((strArray[i].length() % 2) == 0) {  //if there is an even number of characters in the string
    System.out.println(strArray[i]);     //print the string
  }
}