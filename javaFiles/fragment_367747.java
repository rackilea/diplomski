public class ConcreteStub extends Concrete
{
    public int numCallsToBar = 0;
    @Override
    public void bar(String s) { numCallsToBar++; }
}