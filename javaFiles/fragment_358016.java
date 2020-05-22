// abc2xyz
String a = "abc";
String b = "xyz";

String fktRegex = "public double " + a + "2" + b + "\\(double value\\) \\{return value \\* (.*);\\}\n";

String data = "public double abc2xyz(double value) {return value * 100000;}\n";
Pattern p = Pattern.compile(fktRegex);
Matcher m = p.matcher(data);

if(m.find()){
    System.out.println(m.group(1));
}else{
    System.out.println("no match found");
}