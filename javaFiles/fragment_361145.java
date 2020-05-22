enum Foo
{
    foo,
    bar,
    oof;
}

public void func(Foo arg)
{
    if(arg == Foo.bar)
        // do bar code

    switch(arg)
    {
        case foo: // do foo code
        case oof: // do oof code
    }
}