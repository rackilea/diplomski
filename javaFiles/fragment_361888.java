public class Test2 {
    private Pointer first;

    private static class Pointer {
        public Pointer next;
        public Pointer() {
            next = null;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Pointer[] p = new Pointer[1000];
        for ( int i = 0; i < p.length; ++i ) {
            p[i] = new Pointer();
        }

        while (true) {
            try {Thread.sleep(100);}
            catch(Throwable t) {}
        }
    }
}