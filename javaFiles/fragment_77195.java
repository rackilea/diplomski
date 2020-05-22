for (int i = 1; i<=110; i++)
{

   Random r = new Random();

   setArrayValue(tab, i,r.nextInt(2));
   if (i%25==0)
   {
       System.out.println("");
   }
   System.out.print(getArrayValue(tab, i)+"("+i+")"+", ");

 }