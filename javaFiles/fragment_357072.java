@Scheduled(cron="0 0 14-16 * * *")
public void schedule1() {
    schedule2();
}

@Scheduled(cron="0 0-30 17 * * *")
public void schedule2() {
    System.out.println(new Date());
}