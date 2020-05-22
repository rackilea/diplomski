// JSR-303 Validator
import javax.validation.Validator;

@Service
public class MyService {

    @Autowired
    private Validator validator;

}