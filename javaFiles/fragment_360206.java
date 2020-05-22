class check extends Game
{
    public static void controls()
    {
        String commands = command.next();
        if (commands.equals("help"))
        {
            System.out.println("This is the help Menu");
        }

        else if (commands.equals("test"))
        {
            System.out.println("fail");
        }
    }
}