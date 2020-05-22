class Super
{
    abstract void appendTo(Super target);
    abstract void append(Sub1 source);
    abstract void append(Sub2 source);
}

class Sub1
{
    void appendTo(Super target)
    {
        target->append(this); //calls the Sub1 overload
    }
    void append(Sub1 source)
    {
        ... this is Sub1, source is Sub1 ...
    }
    void append(Sub2 source)
    {
        ... this is Sub1, source is Sub2 ...
    }
}
class Sub2
{
    void appendTo(Super target)
    {
        target->append(this); //calls the Sub2 overload
    }
    void append(Sub1 source)
    {
        ... this is Sub2, source is Sub1 ...
    }
    void append(Sub2 source)
    {
        ... this is Sub2, source is Sub2 ...
    }
}