String one = "$615.00";
String two = "$15.00";

double newone = Double.parseDouble( one.substring(1) );
double newtwo = Double.parseDouble( two.substring(1) );

System.out.println(newone-newtwo);