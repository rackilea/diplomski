@Dao 
public interface OrderDao { 
    @Insert(onConflict = OnConflictStrategy.REPLACE) 
    public long insertOrder(Order order); 

    @Insert(onConflict = OnConflictStrategy.REPLACE) 
    void insertAllOrders(List<Order> order); 

    @Query("SELECT * FROM orders") 
    List<Order> getAll(); 
 }

@Entity(tableName = TABLE_NAME) 
public class Order { 
   public static final String TABLE_NAME = "orders"; 
   @PrimaryKey (autoGenerate = true)
   private int id; 
   @SerializedName("order_number") 
   @ColumnInfo(name = "order_number") 
   private String orderNumber; 
} 

// Call 
mDb.getOrderDao().insertAllOrders(orders);
Log.d(TAG, "inserted all");

Executor executor = Executors.newSingleThreadExecutor();

executor.execute(new Runnable() {
        @Override
        public void run() {

             List<Order> myOrders = mDb.getOrderDao().getAll();
             Log.d(TAG, "Orders nr = " + myOrders.size()); 
        }
});