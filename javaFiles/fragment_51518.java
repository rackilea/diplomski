@RestController
@RequestMapping("/restapi")
public class RestService {

    @Autowired
    private DBClass db;

    @PostMapping("/insert")
    public void insert(@RequestBody String body){
        db.insert(body);
    }

}