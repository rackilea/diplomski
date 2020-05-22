public class triangle
{

    public static void main(String args[])
    {
        /*declarations*/
        Scanner input= new Scanner(System.in);

        /*
         * No need to create this variable here.
         * Just create a variable when you need it.
         *
        int how_many;/*number of rows/
         */

        /*
         * The i and j variables can be declared right within the 
         *  for loop.
         * 
        int i;
        int j;
         */

        /*
         * It's println, not printIn
         */
        /*prompt for input*/
        System.out.println("Choissiez un nombre entier postif");

        /*
         * You can just create the variable right here, int how_many
         */
        int how_many=input.nextInt();

        /*
         * This for loop is doing nothing. It runs once, thats it.
         * 
         * You want it to loop as many times as the user entered
         *  
        for(int i = 1 ; i <= 1 ; i++)
         */
        for(int i = 1 ; i <= how_many ; i++)
        {
            /*
             * In this nested loop you need to print out the number of
             *  asterisks depending on the iteration of the parent loop
             * 
            for(int j=1; j<=i; j++)
             */
            for(int j = 1 ; j <= i ; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /*
     * This entire for loop is not within any method.
     * 
     * You need to bring it a few lines
     * 
    for(i=1;i<=1;i++)
    {
        for(j=1;j<=i;j++)
        {
            System.out.print("*");
        }

        System.out.printIn();
    }
     */
}