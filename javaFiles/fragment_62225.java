private Map<String, InputType> inputHandlers;

public void registerNewInput(String name, InputType typeHandler)
{
    inputHandlers.put(name, typeHandler);
}

public void handleInput(String handlerName, String input)
{
    InputType handler = inputHandlers.get(handlerName); // no cast needed here
    handler.handleInput(input);
}