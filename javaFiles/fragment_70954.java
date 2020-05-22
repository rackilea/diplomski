@RestController
public class ExampleController {

    private ResourceLoader resourceLoader;

    @Autowired
    public ExampleController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private List<String> getFiles() throws IOException {
        Resource[] resources = ResourcePatternUtils
                .getResourcePatternResolver(loader)
                .getResources("classpath*:elcordelaciutat/*.txt");

        return Arrays.stream(resources)
                   .map(p -> p.getFilename().toUpperCase())
                   .sorted()
                   .collect(toList());

    }
}