String input = "09:00 19:00";
String[] values = input.split(" ");
String startTime = values[0];
String endTime = values[1];
System.out.println(startTime); // prints: 09:00
System.out.println(endTime);   // prints: 19:00