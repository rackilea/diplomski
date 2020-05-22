public void foo() {
    final String x = "hello";
    String y = "there";

    Runnable runnable = new Runnable() {
        @Override public void run() {
            System.out.println(x); // This is valid
            System.out.println(y); // This is not
        }
    };
    runnable.run();
}