@Service
@Transactional
public class MyService {

    @Autowired
    private PropertyDao propDao;

    public MyService(PropertyRepository repo) {
        propDao = PropertyDao.setRepository(repo);
    }


    HashMap<String,String> getPropertiesMap() {
        return propDao.getPropertiesMap();
    }
}