interface top
{
   void method1(); 
}

interface next extends top
{
    void method2();
}

class A implements next
{
    public void method1()
    {
        ... something ...
    }

    public void method2()
    {
        ... something ...
    }
}

class B implements top
{
    public void method1()
    {
        ... something ...
    }
}