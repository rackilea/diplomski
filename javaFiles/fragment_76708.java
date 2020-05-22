@Entity
@Table(name="A")
public class A {
   @Id @GeneratedValue(strategy=GenerationType.AUTO)
   long id;

   @Column(name="x")
   String x;

   @OneToMany(mappedBy="id.a", cascade=CascadeType.ALL, orphanRemoval=true)
   @MapKey(name="id.locale")
   Map<String, B> bMap = new HashMap<String, B>();
}

@Entity
@Table(name="B")
public class B {
   @EmbeddedId
   BPK id;

   @Column(name="z")
   String z;
}

@Embeddable
public class BPK implements Serializable {
   @ManyToOne
   @JoinColumn(name="a_id")
   A a;

   @Column(name="locale")
   String locale;

   // equals + hashcode
}