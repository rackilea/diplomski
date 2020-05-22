@Service
public class SomeService {

    @Value("${property.name}")
    private int value;

    @Autowired
    private ObjRepository objRepository ;

    public List<Obj> getObjs(int arg) {
        return objRepository.getObjs(arg, value);
    }
}