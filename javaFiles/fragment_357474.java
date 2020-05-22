public class Games {

public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    System.out.println("How many games have you played? (Limit of 10) : ");
    String nextLine = input.nextLine();

    int gamesplayed = toInteger(nextLine);

    while (gamesplayed < 0 || gamesplayed > 10) {
        System.out.println("Wrong input, try again.");
        gamesplayed = toInteger(input.nextLine());
    }

    System.out.println(String.format(
            "How many of these games have you finished? (Limit of %d) : ",
            gamesplayed));
    nextLine = input.nextLine();
    int finishedgames = toInteger(nextLine);
    while (finishedgames < 0 || finishedgames >  gamesplayed ) {
        System.out.println("Wrong input, try again.");
        finishedgames = toInteger(input.nextLine());;
        if (finishedgames > gamesplayed) {
            System.out.print("Invalid Entry. ");
        }
    }

    int list[] = new int[finishedgames];
    for (int i = 0; i < finishedgames; i++){

        System.out.println(String.format("How many time you took to finish your game %d?", i + 1));
        int val = toInteger(input.nextLine());
        while (val == Integer.MAX_VALUE) {
            System.out.println("Wrong input, try again.");
            val = toInteger(input.nextLine());
        }
        list[i] = val;  
    }

    for (int i = 0; i < list.length; i++) {
        System.out.println(String.format("list[%d] = %d", i, list[i]));
    }
}

// Helper method that converts user entry to integer value
private static int toInteger(String nextLine) {
    try {
        return Integer.parseInt(nextLine);
    } catch (NumberFormatException e) {
        return  Integer.MAX_VALUE;
    }
}