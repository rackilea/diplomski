public static void main(String[] args) {
    final Item item = new Item("id", "cat", "mach", false);

    Thread retrievalThread = new Thread(new Runnable() {
        @Override
        public void run() {
            item.getWorkedItem();
        }
    });

    Thread puttingThread = new Thread(new Runnable() {
        @Override
        public void run() {
            item.putItemToWork("id");
        }
    });

    retrievalThread.start();
    puttingThread.start();
}