public class overflow
{
    public static void main(String[] args)
    {
        String name;

        String[] game = new String[100];
        int[] score = new int[100];
        int[] min = new int[100];

        int nextLine = 0;

        System.out.println("Can you enter your name, game, achievement score, and time played in the following format as shown below:");
        System.out.println("<NAME>");
        System.out.println("<GAME> : <SCORE> : <TIMEPLAYED>");
        System.out.println("Once you have finished your input please notify the program you have finished with the command 'quit':");

        Scanner keyboard = new Scanner(System.in); // initialise Scanner
        name = keyboard.nextLine(); // assign next line of input to name

        int totalGames = 0; // could be nextLine
        int totalScore = 0;
        int totalPlayed = 0;
        int highestScore = 0;

        for (int index = 0; index < 100; index++)
        {
            String input = keyboard.nextLine(); // next line of input

            if (input.compareToIgnoreCase("quit") == 0)
            {
                break;
            }
            nextLine = nextLine + 1;

            String[] variables = input.split(":"); // perform split
            if (variables.length != 3)
            {
                System.out.println("Sorry...  You've incorrectly layed out your data.");
                System.out.println("Please try again!");
            }
            game[index] = variables[0].trim(); // first token trimmed of whitespaces
            try
            {
                score[index] = Integer.parseInt(variables[1].trim()); // Returns an integer/parse second token as int
                min[index] = Integer.parseInt(variables[2].trim()); // Returns and integer/parse third token as int

                totalGames++;
                totalScore += score[index];
                totalPlayed += min[index];
                highestScore = Math.max(highestScore, score[index]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Sorry... I was unable to convert that to a number.");
            }
        }

        System.out.println("Players name: " + name);
        System.out.println("-------------------------------");

        for (int index = 0; index < nextLine; index++) {

            System.out.println("Game: " + game[index] + " | " + "Total Score: " + score[index] + " | " + "Minutes played: " + min[index]);

        }

        System.out.println("");
        System.out.println("");
        System.out.println("Players name: " + name);
        System.out.println("-------------------------------");
        System.out.println("Total games: " + totalGames);
        System.out.println("Overall score: " + totalScore);
        System.out.println("Total minutes played: " + totalPlayed);
    }
}