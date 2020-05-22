int smallest_number(int b[][])
{
  int min = b[0][0];
  int x,y;

for (x = 0; x < b.length; x++)
 {
   for (y = 0; y < b[x].length; y++)
   {
       if (min > b[x][y])
       {
           min = b[x][y];
       }
   } 
 }  

 return min;
 }