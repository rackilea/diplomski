byte[] a= {'A','T'};
String aStr = new String(a);
String regex = "[AG]T";
if(aStr.matches(regex)){
     // Match
}else{
     // Not a match
}