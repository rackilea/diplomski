@Service
public class EntityService {    

    @Autowired
    EntityRepository repository;

    public List<Entity> getEntities(Optional<Long> firstId, Optional<Long> secondId) {
        Specification<Entity> spec = 
            Specifications.where(EntitySpecifications.firstIdEquals(firstId)) //Spring Data JPA 2.0: use Specification.where
                          .and(EntitySpecifications.secondIdEquals(secondId));

        return repository.findAll(spec);        
    }
}