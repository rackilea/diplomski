@Entity
public class Stock_tbl{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int stock_id;
   @ManyToOne
   @JoinColumn(name="session_id")
   private Session_tbl sessionTbl;
   private int price; 

.. Getter and Setter
}

@Entity
public class Session_tbl {
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int session_id;
   private String dateTime; 
   //remove the stock if you dont want to use it
.. Getter and Setter
}