@Entity 
public class TableB implements Serializable {
   @Id
   @GeneratedValue
   private long id;
   @Column
   private String name;
   @Column
   private Date date;

   @OneToMany(mappedBy="tableB")
   private List<TableA> rows;

   public TableB() {}
   //getters, setters, equals, hashCode methods