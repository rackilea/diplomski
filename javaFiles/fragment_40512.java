theName = "";
if(theNum.contains(","){
  int[] theNums = theNum.split(",");     
  for (int num : theNums) {
      theName += p.getProperty(num);
      theName += ",";
  }
  theName = theName.replaceAll(",$", ""); //get rid of trailing comma
}
else
   theName = p.getProperty(theNum);