public class fulldesign7
{
    public static void main(String[] args)
    {
        int star=0;
        int space=5;

        for(int i = 0; i < 9; i++)
        {
            if (i <= 4)
            {
                space--;
                star++;
            }
            else // if (i >= 5)
            {
                space++;
                star--;
            }

            if (i == 3)
            {
                star += 10;
            }
            else if (i == 6)
            {
                star -= 10;
            }

            for(int j=0; j<space; j++)
            {
                System.out.print(" ");
            }

            for(int j=0; j<star; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}