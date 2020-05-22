class A extends C
{
    public UiDevice getDevice()
    {
        return device;
    }
}

abstract class C
{
     public abstract UiDevice getDevice();
     public methodFromC()
     {
         getDevice().doSomethingToDevice();
     }
}