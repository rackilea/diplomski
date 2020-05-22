public class Outer {

    public Outer()
    {
    }

    public void outerMethod()
    {
        final Object o = "fromOuter";
        (new Object() {

            public void innerMethod()
            {
                System.out.println(o);
            }

            final Outer this$0;
            private final Object val$o;


            {
                this$0 = Outer.this;
                o = obj;
                super();
            }
        }).innerMethod();
    }
}