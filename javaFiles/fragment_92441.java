String f = yourFile;
Pattern p = Pattern.compile("setString\\(([^\\)]+)\\)");
Matcher m = p.matcher(f);
while(m.find()) {
   System.out.println("setSpeed to " + m.group(1));
}