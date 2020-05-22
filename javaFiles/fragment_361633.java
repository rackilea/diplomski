public class triangle
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Choissiez un nombre entier postif");

        int how_many = input.nextInt();

        for(int i = 1; i <= how_many; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}