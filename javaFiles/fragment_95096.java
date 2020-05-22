@Id
private String id;

public AbstractBaseEntity() {
    this.id = UUID.randomUUID().toString();
}