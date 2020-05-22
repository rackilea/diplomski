String x1 = "func1(test1)";
String x2 = "func1(test1)";
String methName1 = x1.substring(0, x1.indexOf("("));
String methName2 = x2.substring(0, x2.indexOf("("));
System.out.println(methName1);
System.out.println(methName2);
System.out.println(methName1.equals(methName2));