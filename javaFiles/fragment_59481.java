public class Program
{   
    void test(Program p) {}

    void run() { test(super); }

    public static void main(String[] args)
    {
        new Program().run();
    }
}