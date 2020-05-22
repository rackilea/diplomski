public class java_generic {

    public static void main(String[] args) {
        T t = new X();
        t.m(new Object());
        t.m(new String());
    }

    static class T {
        void m (Object e){
            System.out.println("here is T");
        }
    }

    static class X extends T {
        void m (String o){
            System.out.println("here is X");            
        }
    }
}