@Component
public class MyWorkerComponent {

    @Autowired
    private MyListChecker myListChecker;

    @Scheduled(cron = "0 0 19 * * ?")
    public void doTheListThingy() {
        if (myListChecker.isTheListAvailable()) {
            // your task logic
        }
    }
}