interface IClasspathEntry {}

class Xyz implements IClasspathEntry {}

class main
{
    public static void main(String...args)
    {
        IClasspathEntry[] arr = new IClasspathEntry[1];
        IClasspathEntry inst = new Xyz();
        arr[0] = inst;
    }
}