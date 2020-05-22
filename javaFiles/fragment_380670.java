@Component
public class Service extends AbstractService {
    private OtherService otherService;

    @Autowired
    public void setOtherService(OtherService otherService){...}
}