@Dao
public interface MyDao {

    @Query("SELECT item_quantity FROM item WHERE item_id = :itemId")
    public int getItemQuantity(String itemId);

}