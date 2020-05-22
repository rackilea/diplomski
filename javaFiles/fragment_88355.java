package PackageB

public class BMain
{
    public BMain()
    { }

    public void foo()
    {
        System.out.println("This is not a static method. It requires a new instance of BMain to be created for it to be called");
    }

    public static void bar()
    {
        System.out.println("This is a static method. It can be accessed directly without the need of creating an instance of BMain");
    }
}