double d1 = 0.0345333;
d1 = (double)Math.round(d1*1000)/1000;
System.out.println(d1); // 0.035

double d2 = 0.0345333;
d2 = ((int)(d2 *1000))/1000.0;
System.out.println(d2); // 0.034