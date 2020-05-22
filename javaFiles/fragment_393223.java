class B
{
    public static void main (String[] args)
    {
        A a = new A();
        a.test(B::foo,B::bar); // though foo() and bar() must be static in this case,
                               // or they wouldn't match the signature of the run()
                               // method of the Runnable interface expected by test()
    }
}