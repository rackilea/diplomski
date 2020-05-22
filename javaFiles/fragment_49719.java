public class HGP1316 {
    static int Running_total = 0;
    static double Average = 0.0;
    static int User_input = 0;
    static double counter = 0.0 ;
    static int Highest_input = -1;
    static int Lowest_input = -1;
    public static void main(String[] args) {
        {
            System.out.println("This program will give you the highest, lowest, and average of the integers you \n"
                    + "enter. To end enter a negative number ");
        }

        Scanner user_input = new Scanner( System.in );
        while (User_input >= 0) {
            System.out.print("Please enter an integer: ");
            User_input = user_input.nextInt();

            if (User_input >= 0)
            {
                Running_total = Running_total + User_input;
                counter = counter + 1;
                if (counter == 1)
                {
                    Highest_input = User_input;
                    Lowest_input = User_input;
                }

                if (User_input > Highest_input)
                {
                    Highest_input = User_input;
                }

                if (User_input < Lowest_input)
                {
                    Lowest_input = User_input;
                }
            } else {
                Average = (Running_total / counter);
                System.out.println ("The Highest value entered was : "+ Highest_input);
                System.out.println ("The Lowest value entered was : " + Lowest_input);
                System.out.println("The Average of enteries was : "+ Average);
            }
        }
        user_input.close();
    }
}