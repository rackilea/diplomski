Runnable printSomething = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

new java.lang.Thread(printSomething, "JavaSE-Thread").start();