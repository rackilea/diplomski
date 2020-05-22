@Entity  
@Table(name = "likable")  
@Inheritance(strategy=InheritanceType.JOINED)   
public class Likable {  

   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)     
   @Column(name = "id")  
   private int id;  

 }