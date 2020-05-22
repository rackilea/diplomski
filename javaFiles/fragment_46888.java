public void testMapOfCommands() throws Exception
{
    Map<String, Commands> commands = new HashMap<String, Commands>();
    for(Commands command : Commands.values())
    {
        commands.put(command.name(), command);
    }
}