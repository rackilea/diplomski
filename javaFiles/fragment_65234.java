@Service
public class FooService {
    private String xmlFilePath;
    private ResourceLoader ctx;

    @Autowired
    public FooService(@Value("${xml.file.path}") String xmlFilePath, ResourceLoader ctx) {
        super();
        this.xmlFilePath = xmlFilePath;
        this.ctx = ctx;
    }
}