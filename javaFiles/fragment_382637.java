@RestController
@RequestMapping("/api/osoba")
public class APIController {

@Autowired
private KsiazkaRepo ksiazkaRepo;

@JsonView(OnlyName.class)
@RequestMapping(method = RequestMethod.POST, value = "/getAll")
    public List<Ksiazka> find(@RequestParam("id") int id){
}