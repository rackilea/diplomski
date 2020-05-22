String search = "/bla/$V_N.$XYZ.bla";
String pattern = "[%$]([^%.$]*)";
Matcher matcher = Pattern.compile(pattern).matcher(search);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
} // => V_N, XYZ