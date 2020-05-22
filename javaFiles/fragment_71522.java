Pattern p = Pattern.compile("(\\w+)=\"([^\"]+)\"|([^\\s]+)");

String test = "a0=d235 a1=2314 com1=\"abcd\" com2=\"a b c d\"";
Matcher m = p.matcher(test);

while(m.find()){
    System.out.print(m.group(1));
    System.out.print("=");
    System.out.print(m.group(2) == null ? m.group(3):m.group(2));
    System.out.println();
}