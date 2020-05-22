boolean flag=true;
String searchTerms = "java stackoverflow conditions hello test";
String [] splittedTerm = searchTerms.split(" ");

for(int i=0;i<splittedTerm.length;i++){

  if (!(textLine[i].equals(splittedTerm[i]))){ //textLine is the array containing String literals you want to compare.
   flag=false;
   }

}
start=flag;