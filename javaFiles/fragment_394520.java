// loops through the array until "=\"unicode\">" is found
int startIndex = textToExtract.indexOf("=\"unicode\">");
// loops through the array again, until "</F_TEXT>" is found
int endIndex = textToExtract.indexOf("</F_TEXT>");
//loop through the array, copying the bytes to a new array to form a new String
String substr = textToExtract.substring(startIndex,endIndex);
//loop through the array to find and replace "=\"unicode\">" with nothing
String data = substr.replaceFirst("=\"unicode\">", "");