public static void main (String [] args)
{
    System.out.println ("\t\t\tMultiplication Table");
    System.out.println ();

    for (int i = 0; i <= 9; i++)
    {
        for (int j = 0; j <= 9; j++)
        {
            if(j == 0) System.out.print("\t" + i); 
            else if(i == 0) System.out.print("\t" + j);
            else System.out.print("\t" + i * j);
        }
        System.out.println();
    }
}