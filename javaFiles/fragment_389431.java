public class X {
    interface Func {
        int plus(int x);
    }

    public void myFunc() {
        final int z = 3;

        myOtherFunc(new Func() {  // Anonymous class declaration
            public int plus(int x) {
                return z + x;
            }
        });
    }

    public void myOtherFunc(Func f) {
         System.out.println(f.plus(8));
    }
}