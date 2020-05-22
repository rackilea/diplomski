public class FinalizeStuff<Foo> extends PhantomReference<Foo> {

    public FinalizeStuff(Foo foo, ReferenceQueue<? super Foo> queue) {
        super(foo, queue);
    }

    public void bar() {
        System.out.println("foobar is finalizing resources");
    }
}