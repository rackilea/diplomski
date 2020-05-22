@Entity
@Table(name="A")
public class A {
   @Id @GeneratedValue(strategy=GenerationType.AUTO)
   long id;

   @Column(name="x")
   String x;

   @ElementCollection
   @CollectionTable(name="B", joinColumns=@JoinColumn(name="a_id"))
   @MapKeyColumn(name="locale")
   Map<String, B> bMap = new HashMap<String, B>();
}

@Embeddable
public class B {
   @Column(name="z")
   String z;
}