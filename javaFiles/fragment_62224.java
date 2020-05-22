public void registerNewInput(String name, InputType typeHandler)
{
    inputHandlers.put(name, typeHandler);
}

public void handleInput(String handlerName, String input)
{
    InputType handler = (InputType) inputHandlers.get(handlerName);
    handler.handleInput(input);
}