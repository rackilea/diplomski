public class Example {

    public void method() {
        String localFoo = "local";
        new Object() {
            public void bar() {
                foo = "bar"; // yup
                System.out.println(localFoo); // sure
                localFoo = "bar"; // nope
            }
        };        
    }

    private String foo = "foo";
}