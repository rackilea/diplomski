class ClosableDummy implements Closeable {
    public void close() {
        System.out.println("closing");
    }
}

public class ClosableDemo {
    public static void main(String[] args) {
        try (ClosableDummy closableDummy = new ClosableDummy()) {
            System.out.println("try exit");
            throw new Exception();
        } catch (Exception ex) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }


    }
}