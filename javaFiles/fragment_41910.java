@Table(name = "registration")
@Entity
public class Registration{

   @Id
   @Column(name = "r_id")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Basic
   @Column(name = "r_name")
   private String name;

   // getters and setters

}