String s = "name=type,info1;101;localhost;-1;false;false";
String[] words = s.split("=|,");
String name = words[0];
String type = words[1];
String info = words[2];
System.out.println("Name: " + name + "\nType: " + type + "\nInfo: " + info);