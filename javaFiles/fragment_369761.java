import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Inject
    private MyUtil         myUtil;


    public void init() {
        myUtil.connect();
    }
}