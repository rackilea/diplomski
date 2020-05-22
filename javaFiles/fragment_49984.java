public boolean isPalindrome(int x)
   {

      int reverse = 0;
      int remainder = 0;
      int originalX = x;

      while (x > 0)
      {
         remainder = x % 10;
         reverse = reverse * 10 + remainder;
         x = x / 10;
      }

      return (reverse == originalX);

   }