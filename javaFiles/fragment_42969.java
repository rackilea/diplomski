public static void mySleep (int val) {
    try { 
        TimeUnit.SECONDS.sleep(val);
    } catch (InterruptedException e) {
        log.error("Thread interrupted");
    }
}