public class Outer {

    public static void main(String[] args) {

        Outer o1 = new Outer(1);
        Outer o2 = new Outer(2);

        o1.doSomething();
        o2.doSomething();

    }

    private int i;
    private int j = 10;

    public Outer(int i) {
        this.i = i;
    }

    public void doSomething() {
        new Runnable() {

            private int i = 0;

            public void run() {
                System.out.println("Inner i = " + i);
                System.out.println("Outer i = " + Outer.this.i);
                System.out.println("Outer j = " + j);
            }
        }.run();
    }
}