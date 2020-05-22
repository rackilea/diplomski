synchronized void hit(long n) throws InterruptedException {

    for (int i = 1; i < 3; i++){
        System.out.print(n + "-" + i + " ");
        Thread.sleep(0);
    }
}