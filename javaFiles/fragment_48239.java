class A
{
    public static void main(String[] args)
    {
        A a = new A();
        WeakReference<A> wr = new WeakReference<>(a);
        a = null;

        System.out.println(a);

        try {
            System.gc(); // instance of A is garbage collected
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(wr.get());
    }

    @Override
    protected void finalize( )
    {
        System.out.println(Thread.currentThread().getName() + ": See ya, nerds!");
    }
}