public static double harmonicRecursive(double x)
{
   if(x <= 1.0)
   {
       return 1.0;
   }
   else
   {
       return x * harmonicRecursive(1.0 / (x - 1.0));
   }
}