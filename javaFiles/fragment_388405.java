@Scheduled(cron = "0/3 * * * * *")
public void work() {
    log.info("begin to do some work,current thread is {}", Thread.currentThread().getName());
    try {
        TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
        log.error(e.toString());
    }
}