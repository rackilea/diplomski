double d = 0.18;
String numberD = String.valueOf(d);
numberD = numberD.substring ( numberD.indexOf ( "." ) + 1);
System.out.println(numberD); // Print as String
System.out.println(Integer.parseInt(numberD)); // print as Integer

//Output
 18