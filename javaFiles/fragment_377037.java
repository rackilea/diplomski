@Entity
public class Stock_tbl{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int stock_id;

   private int session_id; //now it is a simple id, not relationships/objectc
   private int price; 
.. Getter and Setter
}