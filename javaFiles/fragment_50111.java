@RestController
@Api(produces = "application/json", protocols = "https", tags =    "Securities", description = "Securities  information")
public class SecuritiesInfoController extends Controller {

@Autowired
private SecuritiesInfoManager _securitiesInfoManager = new   SecuritiesInfoManager();

@RequestMapping(value = "/security", method = RequestMethod.GET)
   public List<SecuritiesInfo> getAll(){ 
return _securitiesInfoManager.getAll(); 
 }
}