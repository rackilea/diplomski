public static int sumLuhnDigits(long number, boolean odd) {
    return sumLuhnDigits(number, odd, 0);
} 

private static int sumLuhnDigits(long number, boolean odd, int count) {
   if (number <= 0) return count;
   if (!odd) {
       count += number % 10;
   } else {
       count += (number % 10) * 2;
  } 
  number = number / 10;
  odd = !odd;
  return sumLuhnDigits(number, odd, count);
}