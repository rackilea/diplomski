double A = 1L;
double B = 999999999l;
double C = 1000000000l;
double D = 9999999999l;
double X = 999999998l;
double Y = (D - C) * (X - A) / (B - A) + C;

System.out.println("original is " + new DecimalFormat("#").format(X));
double reverseX = (B - A) * (Y - C) / (D - C) + A;
System.out.println("reverse is  "
        + new DecimalFormat("#").format(reverseX));