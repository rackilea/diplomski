@Embeddable
public class MyCompositeKey implements Serializable{

    @Column(name = "test_id", nullable = false)
    @Getter
    @Setter
    private Long testId;

    @Column(name = "other_test_id")
    @Getter
    @Setter
    private Long otherTestId;
}


@Entity
@EqualsAndHashCode(of = "compositeKey")
@Table(name = "test_table")
@Data
class Dummy{

    @EmbeddedId
    @Column(name = "test_id", nullable = false)
    private Long compositeKey;
}