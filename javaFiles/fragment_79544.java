@Autowired
private SchedulerFactoryBean schedulerFactory;

@RequestMapping(value = "/triggerJob", method = RequestMethod.GET)
public ResponseEntity<String> triggerJob() {
    try {
        schedulerFactory.getScheduler().triggerJob("statisticsJob", "default");
    } catch (SchedulerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return new ResponseEntity<>(HttpStatus.OK);
}