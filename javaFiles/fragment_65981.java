new Runnable() {
    @Override
    public void run() {
        new A(); // just creating an instance of 'A' for every call to 'run'
    }
}