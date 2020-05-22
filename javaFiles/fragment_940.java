import java.util.EnumSet;

// Please don't ever use this code. It's here so you can point and laugh.
enum Foo 
{ 
    A(10), B, C, D(5000), E, Fish;

    private static int nextValue;
    private int value;

    private Foo()
    {
        this(Counter.nextValue);
    }

    private Foo(int value)
    {
        this.value = value;
        Counter.nextValue = value + 1;
    }

    public int getValue() 
    {
        return value;
    }

    private static class Counter
    {
        private static int nextValue = 0;
    }
}

public class Test
{
    public static void main(String[] args)
    {
        for (Foo foo : EnumSet.allOf(Foo.class))
        {
            System.out.println(foo.name() + " " + 
                               foo.ordinal() + " " + 
                               foo.getValue());
        }
    }
}