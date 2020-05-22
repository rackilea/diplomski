public class Test
{
    int a = 10;
    public Test()
    {
        int a = 20;
        System.out.println(a); // prints 20
        System.out.println(this.a); // prints the "a" defined in the class. In this case, 10
    }

    public static void main(String[] args)
    {
        new Test();
    }
}