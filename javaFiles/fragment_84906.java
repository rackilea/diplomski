public boolean isArmstrongNumber(int n) {
    int sum = 0, temp = n, remainder, digits = 0;
    while (temp != 0) {
         digits++;
         temp = temp/10;
      }

      temp = n;

      while (temp != 0) {
         remainder = temp%10;
         sum = sum + power(remainder, digits);
         temp = temp/10;
      }
      if (n == sum) //Armstrong number
          return true;
       else //Not Armstrong number
          return false;
}