public class Check {
    public void method() {
        final String[] localVar = {""};
        new Object() {
            public void anonyMethod() {
                System.out.println(localVar[0]); // sure
                localVar[0] = "a"; // nope
            }
        }.anonyMethod();
        System.out.println(localVar[0]);
    }

    public static void main(String[] args)
    {
        Check ck = new Check();
        ck.method();
    }
}