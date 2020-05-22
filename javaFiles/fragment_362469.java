public static void main(String[] args)
{
    Scanner getReq = new Scanner( System.in );

    List<String> commands = new ArrayList<String>();
    String command;
    while (!(command = getReq.nextLine().trim()).equalsIgnoreCase("end"))
    {
        commands.add(command);
    }
    runCmds(commands);
}

private static void runCmds(List<String> userInputs)
{
    for (String userInput : userInputs)
    {
       //your insanity here :)
    }
}