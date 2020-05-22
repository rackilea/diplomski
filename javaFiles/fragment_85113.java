@MappedSuperclass
public class AbstractEntity {
    @Id @GeneratedValue(generator="uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected UUID uuid;
}