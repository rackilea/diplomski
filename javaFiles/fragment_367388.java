class A implements I
{
    private B b = new B();

    public void m1()
    {
         System.out.println("m1 Method From A");
         b.m2();
    }
}