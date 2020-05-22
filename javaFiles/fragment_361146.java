enum Foo
{
    foo (1),
    bar (2),
    oof (3);

    public final int val;

    Foo(int val)
    {
        this.val = val;
    }
}

public static void main( String[] args )
{
    Foo f = Foo.bar;

    int val = f.val;
}