final Data data = new Data();
for (int i = 0; i < numberOfThreads; i++) {
    final Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (data){
                final int value = data.getValue();
            }
            synchronized (data){
                data.setValue(value + 1);
            }
        }
    });
    thread.start();
}