public class Stars1
{
    public static void main(String[] args)
    {
System.out.println("Enter no of rows to be printed");

   int  row= Integer.parseInt(args[0]);

          int len = args.length;

         if( len <= 0)
         {
             System.out.println(" ERROR: Please input a value of 1-5");
             System.exit(0);
         }  

        int j;
        for(int i = 0; i <= row; i++)
        {
            for(j = 0; j <= i; j++)
                System.out.print("*");

            System.out.println("");


        }


    }
}