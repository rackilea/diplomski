public class MyClass {

    public static void main(String[] args) throws Exception {
        A a = new A<String>();
        a.fi("foo");
        a.fj("bar");
        return;
    }

    public interface I<T> {
        void  fi(T t);
    }

    public interface J<T> extends I<T> {
      void fj(T t);
    }

    public static class A<T> implements J<T> { 
        // it is static only to be accessible from main()
        public A() {
            // default constructor
        }

        public void fi(T t) {
            System.out.println("method from I, arg=" + b.toString());
        }

        public void fj(T t) {
            System.out.println("method from J, arg=" + b.toString());
        }
    }
}