public class Main {
    public static void main(String[] args)
    {
        Foo foo = new Main().new Foo("Foo");
    }
    class Foo
    {
        public Foo(String A)
        {
            System.out.println(A);
        }
    }
}