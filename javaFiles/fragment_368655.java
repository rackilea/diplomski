public interface IUpdatable
{
    public void setB(boolean newValue);
}

public class Test implements IUpdatable
{
    private boolean b;
    public String getb(){}
    public void setB(boolean newValue) {this.b = newValue;}
}

public class ClassSingleton
{
    public String doSomething(IUpdatable updatable)
    {
        updatable.setB(true);
        ...
    }
}