String host = "abs:1025, abs:1000, bca:1024";
String hostName = host.substring(0, host.indexOf(":"));
String pattern = hostName +":([0-9]+)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(host);
while(m.find()){
  System.out.println(m.group(1));
}