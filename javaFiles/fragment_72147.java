@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class IdsDao {

    @Transactional(propagation = Propagation.SUPPORTS)
    public MyData getData(List<UUID> list) {
        // ... 
    }
}