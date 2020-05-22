public class Product implements PersistentEntity {

    private String id;

    public Product() {
        id = IdGeneratorHolder.getIdGenerator(getClass()).generate();
    }

    @PrePersist
    public void generateId() {
        id = IdGeneratorHolder.getIdGenerator(getClass()).generate();
    }

}