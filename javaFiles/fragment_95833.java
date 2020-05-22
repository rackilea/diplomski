String str = "nameadress=johndoe&adress=newyork163thdowntown&phone=+341431242";
String[] firstSplit = str.split("&");

System.out.println(firstSplit[0]); // Prints nameadress=johndoe
System.out.println(firstSplit[1]); // Prints adress=newyork163thdowntown
System.out.println(firstSplit[2]); // Prints phone=+341431242

String name = firstSplit[0].split("=")[1]; // johndoe
String address = firstSplit[1].split("=")[1]; // newyork163thdowntown
String phone = firstSplit[2].split("=")[1]; // +341431242