@MappedSuperclass
public class PKEntity {

    @Id
    @GenericGenerator(name="universal", etc. etc. etc.)
    @GeneratedValue(generator="universal")
    private Long id;

    // Possibly more common columns your entities have
}