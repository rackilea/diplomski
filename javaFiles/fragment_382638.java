@RestController
@RequestMapping("/api/osoba")
public class APIController {

@Autowired
private KsiazkaRepo ksiazkaRepo;

@JsonView(OnlyName.class)
@RequestMapping(method = RequestMethod.POST, value = "/getAll")
    public List<Ksiazka> find(@RequestParam("id") int id){
     List<String> autor = ksiazkaRepo.findInfoById(id); // get result as as  list
     List<Ksiazka> ksiazkaList = new ArrayList<>(); // create list from Ksiazka 
     for (String autors : autor) { // returned result you can loop 
    Ksiazka ksiazka = new Ksiazka(); // create Object to Ksiazka

    ksiazka.setAutor(autors);
    ksiazkaList.add(ksiazka); //add created object to List
        }
       return ksiazkaList; // return your list

       }