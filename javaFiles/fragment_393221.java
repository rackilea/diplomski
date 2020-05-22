class A
{
    public void test(Runnable method, Runnable method2)
    {
        if(Condition)
        {
            method.run();
        }
        else
        {
            method2.run();
        }
    }
}

class B
{
    public static void main (String[] args)
    {
        A a = new A();
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("hello1");
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("hello2");
            }
        };
        a.test(r1,r2);
    }
}