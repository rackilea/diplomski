public class AuditedEntityWithEmedded {

    public AuditedEntityWithEmedded() {
        this(UUID.randomUUID().toString());
    }

    public AuditedEntityWithEmedded(String id) {
        this.id = id;
    }

    @Id
    @NotNull
    private final String id;

    @Column
    private String nom;


    @ElementCollection(targetClass = EmbeddableEntity.class, fetch = FetchType.EAGER)
    @JoinTable(name = "entity_embedded_entity", joinColumns = @JoinColumn(name = "AuditedEntityWithEmedded_id"))
    @OrderColumn // <--- HERE
    private List<EmbeddableEntity> embeddedList;
}