public static void main(String[] args) throws Exception {
    MyThread[] myThreads = new MyThread[4];
    for (int i = 0; i < myThreads.length; i++) {
        myThreads[i] = new MyThread(jedisPool);
        myThreads[i].start();
    }
    jedisPool.close();
}