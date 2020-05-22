int len = 15;
String spacer = String.format("%" + len + "d", 0).replace("0", " ");

String myNumber1 = "123,321,321,321";
String myNumber2 = "321,324,213";

System.out.println(spacer.substring(myNumber1.length()) + myNumber1);
System.out.println(spacer.substring(myNumber2.length()) + myNumber2);