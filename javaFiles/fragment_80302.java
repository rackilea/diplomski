public int getMaxSum(int[] numbers)
{
   //this stores the highest sum we have found so far
   //Integer.MIN_VALUE is the smallest possible value,
   //but your assignment would work with maxSum = -10000;
   int maxSum = Integer.MIN_VALUE;

   //starting at the 1st number in the list, then the 2nd, etc
   for (int pos = 0; pos < numbers.length; pos++)
   {

      //will temporarily hold the sum of numbers from "pos" onwards
      int val = 0;

      //take the number at "pos + 0", then "pos + 1", etc
      for (n = 0; n< numbers.length - pos; n++)
      {
         //add the next number to the current tally
         val += numbers[pos + n];

         //if it is bigger, then we have a new highest sum
         if (val > maxSum) maxSum = val;

      }
   }

   //now maxSum should hold the highest sum
   return maxSum;
}