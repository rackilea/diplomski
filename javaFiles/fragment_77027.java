public ScHandler create(Action action)
{
  switch (module)
  {
    case CONSOLE :
      return new ConsoleHandler(action);