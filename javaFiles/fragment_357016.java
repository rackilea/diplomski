String input = "Lastname,   firstname   middlename";
String regexp = "([A-Za-z]+),\\s+([A-Za-z]+)\\s+([A-Za-z]+)";

Pattern pattern = Pattern.compile(regexp);
Matcher matcher = pattern.matcher(input);
matcher.find();
System.out.println("Lastname  : " + matcher.group(1));
System.out.println("Firstname : " + matcher.group(2));
System.out.println("Middlename: " + matcher.group(3));