double a = 10.19823493;
double b = 1.2;

NumberFormat formatter = NumberFormat.getInstance();
formatter.setMaximumFractionDigits(2);
formatter.setMinimumFractionDigits(2);

System.out.println(formatter.format(a)); // "10.20"
System.out.println(formatter.format(b)); // "1.20"