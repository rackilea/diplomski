public abstract class MessageWrapper
{
  public MessageWrapper(YourMessageType type)
  {
    this.type = type;
  }

  public abstract YourMessageType getType();
}

public class FooMessage extends MessageWrapper
{
  public FooMessage()
  {
    super(YourMessageType.FOO);
  }
}