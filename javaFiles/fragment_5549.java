Integer oldValue;
try{
 oldValue= Integer.parseInt(myString);
}catch(NumberFormatException e){
  oldValue =0;
}