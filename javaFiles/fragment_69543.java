public abstract class BaseThing
{
    public abstract IProcessor GetProcessor();
}

public class SpecificThing : BaseThing
{
    public override IProcessor GetProcessor()
    {
        return new SpecificThingProcessor();
    }
}

public class DifferentThing : BaseThing
{
    public override IProcessor GetProcessor()
    {
        return new DifferentThingProcessor();
    }
}