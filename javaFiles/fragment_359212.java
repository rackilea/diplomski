@Repository
public interface MyEntity extends PagingAndSortingRepository<MyEntity, String> {

    List<MyEntity> findByFieldIn(Set<String> myField);

}