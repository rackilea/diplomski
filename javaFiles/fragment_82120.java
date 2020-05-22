@Entity
@Table(name="quiz")
public class Quiz {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Task> tasks = new ArrayList<>();
}