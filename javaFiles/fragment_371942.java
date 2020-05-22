@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="descriminatorColumn")
@Table(name="AbstractCatalog")
public abstract class AbstractCatalog {
    @Id
    private long id;
    ...
}

@Entity
@Table(name = "CountryCatalog")
public class CountryCatalog extends AbstractCatalog {
    // id is inherited
    ...
}

public interface AbstractCatalogRepository 
                 extends JpaRepository<AbstractCatalog, Long> {

}

@Repository
public class CountryCatalogServiceImpl implements CountryCatalogService {

    @Autowired
    private AbstractCatalogRepository catalogRepository;

    @Override
    public List<CountryCatalog> findAll() {
        return (List<CountryCatalog>)(List<?>)catalogRepository.findAll();
    }

    @Override
    public CountryCatalog findOne(long id) {
        return (CountryCatalog)catalogRepository.findOne(id);
    }   
}