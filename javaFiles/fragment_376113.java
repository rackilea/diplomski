int number = 463;
int radix = 1;
String result = ""; // prob use int[] or list in real life?

while (number > 0) {
   int div = number / radix;
   int remainder = number % radix;
   result = remainder + result;
   number = div;
   ++radix;
}