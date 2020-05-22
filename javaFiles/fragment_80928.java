@Service
public class DataService {
    @Autowired
    private DatabaseDAO database;

    public List<String> getDataAsList() {
        List<String> out = database.getAllRecords();
        out.add("Create New...");
        return out;
    }
}