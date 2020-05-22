class SuperClass
{
    protected boolean hasProperty;

    protected Property getProperty()
    {
        throw new UnsupportedOperationException();
    }
}

class SubOne extends SuperClass
{
    protected Property prop;   

    SubOne()
    {
        this.hasProperty=true;
        this.prop=new Property(); 
    }

    @Override
    protected Property getProperty()
    {
        return prop;
    }
}

class SubTwo extends SuperClass
{
    SubTwo()
    {
        this.hasProperty=false;
    }
}