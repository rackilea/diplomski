public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
    List<MyEntity> findAllCustom(Pageable pageable);
    List<MyEntity> findAllCustom();
}

@Entity
@NamedQuery(
    name = MyEntity.FIND_ALL_CUSTOM, query = "select me from MyEntity me where me.age >= 18"
)
public class MyEntity {
    public static final String FIND_ALL_CUSTOM = "MyEntity.findAllCustom";
}