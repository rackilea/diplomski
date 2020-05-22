// This will give the same problem
String x = "^(?=.*\d)(?=.*[A-Z]).{6,8}$";

// Demo of fix
String working = "^(?=.*\\d)(?=.*[A-Z]).{6,8}$";
System.out.println(working);