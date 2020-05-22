float floatNumber= 4.95f;
double doubleNumber = (double) floatNumber;
System.out.println("After cast " + doubleNumber);
System.out.printf("Show two decimal places. %.2f%n", doubleNumber);
doubleNumber = Math.round(doubleNumber * 100) / 100.0;
System.out.println("After rounding to two places " + doubleNumber);