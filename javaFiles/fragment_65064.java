@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Embedded
    private Metadata metdata;
}