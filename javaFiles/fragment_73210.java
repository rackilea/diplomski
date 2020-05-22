String response = ";function gH(a){a=a.split(\"\");fH.vF(a,36);fH.DZ(a,42);fH.kG(a,1);fH.vF(a,23);fH.DZ(a,29);fH.vF(a,41);fH.DZ(a,2);fH.kG(a,2);fH.vF(a,17);return a.join(\"\")};";
String pattern = "function\\s+..\\(a\\)\\{a=a\\.split\\(\"\"\\);(.*?)return\\s+a\\.join\\(\"\"\\)};";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(response);
String code = "";
while(m.find())
{
   code = m.group(1);
}
System.out.println("Center:" + code);