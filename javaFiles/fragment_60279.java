int seconds = 123;
int minutes = 120;
int hours = 23;
int days = 10;

minutes += seconds / 60;
seconds %= 60;
hours += minutes / 60;
minutes %= 60;
days += hours / 24;
hours %= 24;

System.out.format("%d days, %02d:%02d:%02d hours\n", days, hours, minutes, seconds);
System.exit(0);