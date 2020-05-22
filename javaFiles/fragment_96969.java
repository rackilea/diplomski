for (int i = 0; i < 10; i++) {
    final int ii = i;
    new Thread(new Runnable(){
        public void run() {
            System.err.println(ii);
        }
    }).start();
}