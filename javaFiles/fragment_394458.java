import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

    @Scheduled(fixedRate = 10000)
    public void myScheduler() {
        System.out.println("Test print");
    }

}