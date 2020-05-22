class MyObject{
    private base baseObj;

    public MyObject(base baseObj){
        this.baseObj = baseObj;
    }

    public void DoSomething()
    {
        //here I need to call method add from class base.
            //use baseObj to call the methods
    }
}


class base
{
    protected final void add(){}      
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