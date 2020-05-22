@Entity(name = "A")
@Table(name = "A")
@Inheritance(strategy = InheritanceType.JOINED)
public class A {
    @SuppressWarnings("unused")
    @Id
    @Column(name = "A_ID")
    private int id;
}