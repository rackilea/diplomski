@Singleton
@Startup
public class LabbBean {
    @Resource
    protected TimerService timerService;

    @PostConstruct
    public void init() {
        //Init your timers from the data in the database here
        for (all your timers) {
            TimerConfig config = new TimerConfig();
            config.setInfo("timer1");
            config.setPersistent(false);

            ScheduleExpression schedule = new ScheduleExpression();
            schedule.dayOfMonth(10);
            schedule.minute(2);
            timerService.createCalendarTimer(schedule, config);
        }
    }

    //method called when timeout occurs
    @Timeout
    public void timeoutHandler(Timer timer) {
        String name = timer.getInfo().toString();
        System.out.println("Timer name=" + name);
    }
}