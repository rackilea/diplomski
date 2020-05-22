public class Super
{
    public void print()
    {
        System.out.println("Hello!");
    }
}

public class Sub extends Super
{
    @Override
    void print() // Invalid
    {
        System.out.println("Package access");
    }
}