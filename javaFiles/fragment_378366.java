NumberFormat number = NumberFormat.getNumberInstance();
number.setMinimumFractionDigits(1);
number.setMaximumFractionDigits(1);
String averageScoreString = number.format(averageScore);
String message = "Average score is: " + averageScoreString;
System.out.println(message);