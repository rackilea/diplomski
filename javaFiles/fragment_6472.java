class MyObject{

    public void DoSomething()
    {
        //here I need to call method add from class base.
        //call like this
        base.add();
    }
}


class base
{
    protected static final void add(){}      
}


class extended extends base {
    private MyObject pObject;
    ...

    public extended(){
        pObject = new MyObject(this);
    }

    {
        pObject.DoSomething();
    }
}