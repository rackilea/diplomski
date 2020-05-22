private final static int NO_DICE = -1;


public static void main(String[] args) {
    int[] dices = new int[5];

    int playerPoints = 0;
    int roundPoints = 0;
    String answer;
    Scanner input = new Scanner(System.in);

    System.out.println("Hello, Welcome To Stuck In The Mud");

    while (playerPoints <= 100) {
        System.out.println("Please roll the dice by pressing 'y' and hitting enter");
        System.out.println("o=================o");

        answer = input.next();

        if (answer.equalsIgnoreCase("y")) {
            for (int i = 0; i < dices.length; i++) {
                if (dices[i] == NO_DICE) {
                    continue;
                }
                dices[i] = rollDice();
                System.out.println("Dice " + i + ": " + dices[i]);
            }