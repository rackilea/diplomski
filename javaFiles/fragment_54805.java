public class loops {
   public static void main(String[] args)
   {
     for (int k = 0; k<3; k++)
     {
       for (int j = 0; j<3; j++)
       {
         if (k ==1 && j == 1)
         {
           System.out.print("( * )");
         } else {
           System.out.print("("+k+","+j+")");
         }
       }
       System.out.println("");
     }
   }
 }