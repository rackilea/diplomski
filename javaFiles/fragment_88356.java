package PackageA

public class AMain
{

    public static void main(String[] args)
    {
        PackageB.BMain.bar();

        PackageB.BMain bInstance = new PackageB.BMain();
        bInstance.foo();
    }
}