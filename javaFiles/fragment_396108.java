public class CronJob {

    @PostConstruct
    public void onStart() {
       LocalDateTime now =LocalDateTime.now();
       if(now.getDayOfWeek() == DayOfWeek.TUESDAY || now.getDayOfWeek() == DayOfWeek.WEDNESDAY  ) {
            if(!now.toLocalTime().equals(LocalTime.MIDNIGHT)) {
                 doJob();
            }
        }

    }

    @Scheduled(cron="0 0 * * 2,3")
    public void onSchedule() {
         doJob();
    }

    public void doJob(){
        //do the job
    }
}