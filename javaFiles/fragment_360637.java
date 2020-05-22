String regex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
String date = "12/12/2018";

System.out.println(date); // Prints 12/12/2018
date = date.replaceAll(regex, "myNewValue");
System.out.println(date); // Prints myNewValue