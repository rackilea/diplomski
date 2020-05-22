class Test
{
    public static int a(){ System.out.println("a"); return 2; }
    public static int b(){ System.out.println("b"); return 3; }
    public static int c(){ System.out.println("c"); return 4; }

    public static void main(String[] args)
    {
        System.out.println(a() + b() * c());
        // Lets make it even more explicit
        System.out.println(a() + (b() * c()));
    }
}