class Foo {
    static String name = "Michael";
    static {
        Thread t = new Thread(new Bar());
        t.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}

class Bar implements Runnable {
    public void run() {
        System.out.println(Foo.name);
    }
}