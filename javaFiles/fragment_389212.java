@RestController
@RequestMapping("/api")
public class PersonController {

@Autowired
private PersonRepository personRepository;

@GetMapping(path = "/persons/findByLastname")
 public Collection<NamesOnly> findByLastname(@Param("lastName") final String lastName) {
   Collection<NamesOnly> result = personRepository.findByLastname(lastName);
   return result;
 }
}