// here you'd compute the max value of all the numbers your printing
double maxValue   = 1721890.23;

int maxDigits     = ((int)Math.log10(maxValue) + 1);
int numCommas     = (maxDigits-1) / 3;
int precision     = 2;
int precDecimalPt = (precision + 1);
int totalWidth    = (maxDigits+precDecimalPt+numCommas);

String formatStr = "$%,"+totalWidth+"."+precision+"f%n";

System.out.printf("Gross Pay:    "+formatStr, 815.74);
System.out.printf("Retirement:   "+formatStr, 3073.18);
System.out.printf("Tax:          "+formatStr, maxValue);