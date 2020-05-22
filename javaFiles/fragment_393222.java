class B
{
    public static void main (String[] args)
    {
        A a = new A();
        a.test(() -> System.out.println("hello1"),() -> System.out.println("hello2"));
    }
}