Pattern p = Pattern.compile("(panLast4|nm14|.*?)([0-9]+)");
String s = "panLast42356";
Matcher m = p.matcher(s);
if ( m.matches() && m.group(1).length()>0 ) {
    System.out.println("name: "+ m.group(1));
    System.out.println("ID: "+ m.group(2));
}