@PostConstruct
public void init() {
    System.out.println("##########init#############");
    scheduler = Executors.newSingleThreadScheduledExecutor();
    scheduler.scheduleAtFixedRate(this, 0, 2, TimeUnit.MINUTES);
    System.out.println("##########end#############");
}