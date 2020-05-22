String str1 = "$SF_Update$";
String str2 = "$SF_Update_One$";
String str3 = "$SF_Update_One";
Pattern pattern = Pattern.compile("\\$([^_]+_{1}[^_]+)\\$");
Matcher matcher1 = pattern.matcher(str1);
Matcher matcher2 = pattern.matcher(str2);
Matcher matcher3 = pattern.matcher(str3);
if (matcher1.matches())
    System.out.println(str1 + " => " + matcher1.group(1));
else
    System.out.println(str1 + " => " + "No Match.");
if (matcher2.matches())
    System.out.println(str2 + " => " + matcher2.group(1));
else
    System.out.println(str2 + " => " + "No Match.");
if (matcher3.matches())
    System.out.println(str3 + " => " + matcher3.group(1));
else
    System.out.println(str3 + " => " + "No Match.");