Pattern p = Pattern.compile("[^,]*(?:,[^,]*){2}$");
String line = "CgIn,f,CgIn.util:srv2,1,11.65,42,42,42,42,04,05,06,07";
Matcher m = p.matcher(line);
String result = "";
if (m.find()) {
    result = m.group(0);
}
System.out.println(result);