class A
{
}

class B extends A 
{
}

interface C
{
    void foo();
}

class CBase extends A implements C
{
    public void foo()
    {
        sFoo(this);
    }

    static void sFoo(C c)
    {
        // Implement foo here
    }
}

class D extends B implements C
{
    public void foo()
    {
        CBase.sFoo(this);
    }
}