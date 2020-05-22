public String gameStart()
{
    String name = "";
    boolean playerNameLike = false;
    while (!playerNameLike)
    {
        System.out.println("So, whats your name?");
        Scanner gameStart = new Scanner(System.in);
        name = (gameStart.next());
        playerNameLike  = nameTest(name);
    }
    return name;
}

public boolean nameTest(String name) // Use your current code from here on