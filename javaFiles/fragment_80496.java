String number = "Balance 123,45 p.";
String[] number_array = number.split(" ");

String str = (number_array[1].replaceAll(",","."));
double d = Double.parseDouble(str);
System.out.println(d);