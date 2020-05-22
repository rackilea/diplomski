@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(nativeQuery=true, value="call your_procedure(:your_parameter)")
    public List<Item> getTopItems(int top);
}