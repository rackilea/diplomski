@Component
public class Bean {
    private String arg;

    public Bean(@Value("{constructorArg}") final String arg) {
        this.arg = arg;
    }
}

@Service
public class Service {

    @Autowired @Getter
    private Bean bean;

    private String arg;

    public Service(@Value("{constructorArg}") String arg) {
        this.arg = arg;
    }
}