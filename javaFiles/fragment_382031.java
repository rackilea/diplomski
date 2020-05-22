public class YourClass {
    static String p1;
    static String p2;

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the game of sticks!");
        playerNames();
        coinToss();
    }

    public static void playerNames()
    {
        Scanner input = new Scanner(System.in);
        System.out.println();

        System.out.print("Enter player 1's name: ");
        p1 = input.nextLine();

        System.out.print("Enter player 2's name: ");
        p2 = input.nextLine();

        System.out.println();
        System.out.println("Welcome, " + p1 + " and " + p2 + ".");
    }

    public static void coinToss()
    {
        System.out.println("A coin toss will decide who goes first:");
        System.out.println();
        Random rand = new Random();
        int result = rand.nextInt(2);
        result = rand.nextInt(2);
        if(result == 0)
        {
            System.out.println(p1 + " goes first!");
        }
        else
        {
            System.out.println(p2 + " goes first!");
        }           
    }

}