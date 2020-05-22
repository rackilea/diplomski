public class Test {
    static volatile Object ref;

    public static void main(String[] args) {
        // spin until ref is updated
        new Thread(() -> {
            while (ref == null);
            System.out.println("done");
        }).start();

        // wait a second, then update ref
        new Thread(() -> {
            try { Thread.sleep(1000); } catch (Exception e) {}
            ref = new Object();
        }).start();
    }
}