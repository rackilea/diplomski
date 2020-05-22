public class A
{
    private int fieldA;
}

public class B extends A implements Cloneable
{
    public B clone() throws CloneNotSupportedException
    {
        return (B)super.clone();
    }
}