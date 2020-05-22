public class TestTest {
    public static void main (String[] args) throws Exception {
        try {
            run();
        } catch(Exception e) {
            printSuppressedExceptions(e);
        }
    }

    public static void printSuppressedExceptions(Throwable t) {
        System.out.println(t);
        System.out.println("suppressed exceptions (" + t.getSuppressed().length + "):");
        for (Throwable suppressed : t.getSuppressed()) {
            System.out.println("  - " + suppressed);
        }
    }

    public static void run() throws Exception {
        Exception exceptionFromCatch = null;
        try(MyResource r = new MyResource("resource");) {
            System.out.println("try");
            System.getProperty("").length(); // throws illegalArgumentException
        } catch(Exception e) {
            exceptionFromCatch = e;
            printSuppressedExceptions(e);
            throw e;
        } finally {
            try {
                new MyResource("finally").close();
            } catch (Exception e) {
                if (exceptionFromCatch!=null) {
                    e.addSuppressed(exceptionFromCatch);
                }
                throw e;
            }
        }
    }   
}

class MyResource implements AutoCloseable {
    private final String name;

    public MyResource(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        throw new Exception("exception" + " from " + this.name);
    }
}