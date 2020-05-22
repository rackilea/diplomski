@Autowired
@Qualifier("demo")
public void demo(EntityRepo repository){
    repository.save(new testEntity("jack"));
}


@Repository("entityRepo")
public interface EntityRepo extends CrudRepository<testEntity, Long>{
List<testEntity> findByName(String name);
}