public interface IProcessor
{
    void Process();
}

public class SpecificThingProcessor : IProcessor
{
    public void Process() { /* Implementation */ }    
}

public class DifferentThingProcessor : IProcessor
{
    public void Process() { /* Implementation */ }
}

public class AnotherThingProcessor : IProcessor
{
    public void Process() { /* Implementation */ }
}