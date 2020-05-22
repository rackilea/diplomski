private static Map<String, MyCommand> getMyCommands()
{
    Map<String, MyCommand> commandList = new HashMap<String, MyCommand>();
    MyCommand c;

    c = new Method1Command();
    commandList.put("constant1", c);

    c = new Method2Command();
    commandList.put("constant2", c);

    c = new Method3Command();
    commandList.put("constant3", c);

    return commandList();
}