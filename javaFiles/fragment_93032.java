String string = "41,\"Premises Type\",\"A\",\"Retail\"";        
string =string.replaceAll("\"", "");
String[] array =string.split(",");
System.out.println(array[0]);
System.out.println(array[1]);
System.out.println(array[2]);
System.out.println(array[3]);