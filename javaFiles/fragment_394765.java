Thread foo = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
});
foo.start(); // Hello World