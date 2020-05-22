import org.springframework.beans.factory.annotation.Value;
// ...

@Service
public class MyService {

    @Value("${port}")
    private String port;

    // ...
}