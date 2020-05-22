static int function(int b) 
{

   for (int c=0;c<b;c++) 
   {

    if(c%5==0) 
    {
        System.out.println(c);
        return c;
    }
} //end for loop
 return -1;     //Or other logic you prefer
}