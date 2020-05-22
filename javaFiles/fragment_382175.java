public class TestResources extends ExternalResource {
    private static int refCount = 0;

    private static TestResources currentInstance;

    public static TestResources getTestResources () {
        if (refCount == 0) {
            // currentInstance either hasn't been created yet, or after was called on it - create a new one
            currentInstance = new TestResources();
        }
        return currentInstance;
    }

    private TestResources() {
        System.out.println("TestResources construction");
        // setup any instance vars
    }

    protected void before() {
        System.out.println("TestResources before");
        try {
            if (refCount == 0) {
                System.out.println("Do actual TestResources init");
            }
        }
        finally {
            refCount++;
        }
    }

    protected void after() {
        System.out.println("TestResources after");
        refCount--;
        if (refCount == 0) {
            System.out.println("Do actual TestResources destroy");
        }
    }
}