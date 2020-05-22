@RestController
public class ParentController {
    @Autowired
    private ParentRepository parentRepository;

    @PutMapping("")
    public void save(@RequestBody @Valid Parent parent) {
        parentRepository.save(parent);

    }