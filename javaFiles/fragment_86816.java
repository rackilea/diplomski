Pattern p = Pattern.compile("insert regex to test string here");
String data = ...;
Matcher m = p.matcher(data);
//warning depending on regex used this may 
//only check part of the string
if(m.matches()){
  int i = Integer.parseInt(data);
}