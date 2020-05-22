String input = "hello man [u-12-d-g]how are you";
String output = input.replaceAll("](\\S)", "] $1");
System.out.println(output);
input = "hello man [u-12-d-g] how are you";
output = input.replaceAll("](\\S)", "] $1");
System.out.println(output);