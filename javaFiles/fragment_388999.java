@Entity
@Table(name = "SOME_TABLE")
@SequenceGenerator(name = "SOME_SEQUENCE", allocationSize = 1, sequenceName = "SOME_SEQUENCE")
public class SomeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SOME_SEQUENCE")
    @Column(name = "ID", unique = true)
    private Long id;
}