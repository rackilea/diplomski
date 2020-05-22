String test1 = "1 2";
String test2 = "2 1 2";
String test3 = "2 11 2";

String regex = "(?<!\\d)1(?!\\d)";
Pattern p = Pattern.compile(regex);

System.out.println("Matches 1: " + p.matcher(test1).find());
System.out.println("Matches 2: " + p.matcher(test2).find());
System.out.println("Matches 3: " + p.matcher(test3).find());