@Entity
public class TestPair implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JsonProperty("target_Test")
    private Test targetTest;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JsonProperty("source_Test")
    private Test sourceTest;
}

@Entity
public class Test {
    private String name;
    @Id
    private String shortname;
}