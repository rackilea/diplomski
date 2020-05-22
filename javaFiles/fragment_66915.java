class Traversor<T> extends Thread {

    Enumeration<T> e;

    public Traversor(Enumeration<T> e) {
        this.e = e;
    }

    public void run() {
        System.out.println("new thread started, traversing vector  elements.....");
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
            try {
                Thread.sleep(4000);
            } catch (Exception ex) {
            }
        }

        System.out.println("new thread completed");
    }
}

class VectorTest {

    public static void main(String args[]) {
        System.out.println("main thread started, creating vector...");
        Vector<String> v = new Vector<>();
        v.addElement("one");
        v.add("three");
        v.add(1, "two");

        Enumeration<String> e = v.elements();
        System.out.println("vector created ,enumeration obtained");
        Traversor<String> th = new Traversor<>(e);
        th.start();
        System.out.println(" new thread launched , suspending main thread");

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        System.out.println("main thread resumed,modifying vector");
        v.add("four");
        v.add("five");
        System.out.println("vector modified, main thread completed");
    }
}