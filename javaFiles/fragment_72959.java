@Id
@Column(columnDefinition = "uuid", updatable = false)
@GeneratedValue(generator = "uuid")
@GenericGenerator(
        name = "uuid",
        strategy = "com.mypackage.UUIDGenerator",
        parameters = {
                @Parameter(
                        name = UUID_NAMESPACE,
                        value = "something"
                )
        }
)
private UUID id;