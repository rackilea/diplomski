// Spring Validator
import org.springframework.validation.Validator;

@Service
public class MyService {

    @Autowired
    private Validator validator;

}