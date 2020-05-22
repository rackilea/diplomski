@Autowired(required=false)
 private TestSchedulderNew testSchedulderNew;

 @GetMapping(value = "/stopScheduler")
 public String stopSchedule() {
     if (testSchedulderNew != null) {
         postProcessor.postProcessBeforeDestruction(testSchedulderNew, 
          SCHEDULED_TASKS);
         return "OK";
     }
     return "NOT_OK";
 }