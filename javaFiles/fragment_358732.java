public class Main {
    public static void main(String... args) {
        int accm = 0;
        TestClass t = new TestClass(542,452);
        while(true){
            t.myVariable = accm;
            accm += t.myFunction();
            if(false) break;
        }
        System.out.println(accm);
    }

    public static class TestClass{
        final int foo;
        final int bar;
        public int myVariable = 2;

        public TestClass(int foo, int bar){
            this.foo = foo;
            this.bar = bar;
        }


        int myFunction(){
            return foo*bar + myVariable;
        }
    }
}