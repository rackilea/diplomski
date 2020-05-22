public enum Choices
{
    STRONGLYDISAGREE("sc-strongly-disagree"),
    SLIGHTLYDISAGREE("sc-slightly-disagree"),
    NONE("sc-none"),
    SLIGHTLYAGREE("sc-slightly-agree"),
    STRONGLYAGREE("sc-strongly-agree");

    private String value;

    Choices(String value)
    {
        this.value = value;
    }

    public String value()
    {
        return value;
    }
}