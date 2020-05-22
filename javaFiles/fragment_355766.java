public class A extends B
{
    int j = 10;

    public void print()
    {
        System.out.println(super.j);
    }

    public static void main(String[] args)
    {
        A obj = new A();
        System.out.println(obj.j); // 10
        obj.print(); // 15
    }
}