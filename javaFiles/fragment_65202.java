@Service
public class EmpDao {

    @Autowired
    private EmpRepository repo;

    public Page<Emp> getPage(Pageable pageable){
        return repo.findAll(pageable);
    }