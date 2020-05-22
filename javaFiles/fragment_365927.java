@Id
@SequenceGenerator(
        name="subscription_id_seq",
        sequenceName="subscription_id_seq",
        allocationSize=7
)
@GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator="subscription_id_seq"
)
@Column(unique=true, nullable=false)
private Integer id;

@Column(
        name="code",
        nullable=false,
        unique=true,
        insertable = false,
        updatable = false,
        columnDefinition = "BIGINT DEFAULT nextval('subscription_code_1_seq')"
)
@Generated(GenerationTime.INSERT)
private Integer code;