@PostConstruct
 public void init() {
       // load the data
 }
 ...
 @PreDestroy
 @Scheduled(fixedRate = 60L * 1000L)
 public void writeCached() {
     // update data to database
 }