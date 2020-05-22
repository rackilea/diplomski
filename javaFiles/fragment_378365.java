int averageScore = 10;
NumberFormat number = NumberFormat.getNumberInstance();
number.setMinimumFractionDigits(1);
number.setMaximumFractionDigits(1);
String message = "Average score is: " + number.format((double) averageScore);
System.out.println(message);