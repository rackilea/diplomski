private static boolean hasDistinctDigits(int number) {
     int numMask = 0;
     int numDigits = (int) Math.ceil(Math.log10(number+1));
     for (int digitIdx = 0; digitIdx < numDigits; digitIdx++) {
         int curDigit = (int)(number / Math.pow(10,digitIdx)) % 10;
         int digitMask = (int)Math.pow(2, curDigit);             
         if ((numMask & digitMask) > 0) return false;
         numMask = numMask | digitMask;
     }
     return true;
 }