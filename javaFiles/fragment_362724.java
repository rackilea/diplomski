String line = "testest=false opResult=Critical extension not supported random=abc srcPort=10";
String pattern = ".*opResult=(.*?)(?:\\s*\\S+=.*|$)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);
if (m.find( )) {
    System.out.println(m.group(1));
}