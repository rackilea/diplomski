public abstract class Foo
{
    protected Foo()
    {
        car();
    }

    public abstract void car();
}

public class Bar 
    extends Foo
{
    private final String value;

    public Bar(final String str)
    {
        value = str;
    }

    public void car()
    {
        // this line will crash because value is null
        System.out.println(value.charAt(0));
    }
}

public class Main
{
    public static void main(final String[] argv)
    {
        final Foo foo;

        foo = new Bar("Hello");
    }
}