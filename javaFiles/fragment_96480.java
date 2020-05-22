import java.util.Scanner;
    class Main
    {
        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            String[] array = new String[5];

            System.out.println("Please enter 5 names to sort");

            for (int i = 0; i < array.length; i++)
            {
                array[i] = input.nextLine();
            }

            for (int i = 0; i < array.length; i++)
            {
                System.out.println(array[i]);
            }

        }
    }