@Service
@EnableScheduling
public class wakeUpDatabase {

    @Autowired
    private DatabaseFleetsAndCarsServices databaseFleetsAndCarsServices;
    //This task is executing every 7h
    @Scheduled(fixedDelay = 25200000)
    public void smartQeury(){
        databaseFleetsAndCarsServices.getEcu();
    }

}