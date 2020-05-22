@Component
@Profile("prod")
public class HackatonScheduler{
    @Scheduled(initialDelay = 1000, fixedDelay = 21600000)
    public void updateHackalistHackathonData() {
        ...
    }
}