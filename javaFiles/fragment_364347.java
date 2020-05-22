String input = "09:00 19:00";
int idx = input.indexOf(' ');
String startTime = input.substring(0, idx);
String endTime = input.substring(idx + 1);
System.out.println(startTime); // prints: 09:00
System.out.println(endTime);   // prints: 19:00