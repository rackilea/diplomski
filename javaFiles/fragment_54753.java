@RestController
@CrossOrigin
@RequestMapping("/v2/statuses/")
public class StatusEndpoint {

    @Resource(name="privateElasticsearchTemplate")
    private ElasticsearchTemplate template;

    @Autowired
    private DocRepository docRepository;

    @Autowired
    private Validator validator;
    //...
}