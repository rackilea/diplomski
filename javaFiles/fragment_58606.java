public static void main (String [] args)
{
   double [] a = {1.1, 2.2, 4.4};
   System.out.println(avg(a) == avg(1.1, 2.2, 4.4));
}
static double avg (double ... numbers)
{
   double total = 0;
   for (int i = 0; i < numbers.length; i++)
        total += numbers [i];
   return total / numbers.length;
}