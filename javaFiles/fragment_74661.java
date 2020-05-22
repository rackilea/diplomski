String inputLine = "12.10654";
String regex = "\\d+(\\.\\d{1,2})?";    
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(inputLine);   
if(m.find())
    System.out.println(m.group());