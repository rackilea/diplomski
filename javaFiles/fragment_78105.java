class C extends A
{
    public C()
    {
        super(2);
    }

    @Override
    public void g()
    {
        this.h();
    }
}

(new C()).g();  // or C c = new C(); c.g();