class Deadlock {
    static CompletableFuture<Integer> cf;
    static int foo;

    public static void printFoo() {
        System.out.println("Print foo " + foo);
    }

    static {
        cf = new CompletableFuture<Integer>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                calcF();
            }
        }).start();
        try {
            foo = cf.get();
            System.out.println("Future result = " + cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();f
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static void calcF() {
        cf.complete(42);
    }
}

public static void main(String[] args) {
    System.out.println("Before foo");
    Deadlock.printFoo();
    System.out.println("After foo");
}