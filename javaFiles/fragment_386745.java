public static void main(String[] args) {
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        public void run() {
            System.out.println("In shutdown hook");
        }
    }, "Shutdown-thread"));
}