public class Outer {

    public void outerMethod() {
        final Object o = "fromOuter";
        new Object() {
            public void innerMethod() {
                System.out.println(o);
            }
        }.innerMethod();
    }
}