class Task implements Runnable {
    AtomicReference<String> atomicReference = new AtomicReference<String>(null);

    @Override
    public void run() {
        while (true) {
            String command = atomicReference.getAndSet(null);
            if (command != null) {
                //do staff with command
            }
        }
    }

    public void executeCommand(String command) {
        atomicReference.set(command);
    }
}