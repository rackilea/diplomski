public interface ItemRepository extends JpaRepository<Item,Long>, QueryDslPredicateExecutor<Item> {

@Query("select item from Item item where item.user.login = ?#{principal.username}")
Page<Item> findByUserIsCurrentUser(Pageable pageable);

Page<Item> findAll(Predicate predicate, Pageable pageable);