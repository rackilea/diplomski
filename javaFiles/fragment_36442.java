String complexNum = "5+3i"; 
String regex = "(\\d+)[+-](\\d+)i";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(complexNum);

if(matcher.find()){
   int real = Integer.parseInt(matcher.group(1));
   int imag = Integer.parseInt(matcher.group(2));
}