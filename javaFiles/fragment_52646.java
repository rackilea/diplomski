public enum Messages
{
    WARNING("main.message.warning"),
    ERROR("main.message.error");

    private final String message;

    // Parameters to the enum constructors are the ones in the enum "definition"
    Messages(final string message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }
}