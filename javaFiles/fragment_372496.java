public static void usersMove(String playerName, int gesture)
{
    // just for fun, to catch bugs
    if (userMove < -1) {
        throw new IllegalStateException("illegal userMove value " + userMove);
    }

    if (userMove == -1)
    {
        System.exit(0);
    }
}

public static void game()
{
    move();
    Scanner scan = new Scanner(System.in);
    userMove = scan.nextInt();
}