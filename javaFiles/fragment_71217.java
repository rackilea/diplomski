String str = "James Gosling was an Engineer";
String p = "James\\s+(\\w+).*?(\\w+)";
Pattern ptrn = Pattern.compile(p);
Matcher m = ptrn.matcher(str);
if(m.matches()){
    System.out.println(m.group(1) + " - "+m.group(2)) ; 
}