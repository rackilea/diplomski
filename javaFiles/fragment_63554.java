interface BaseEntity <E extends BaseEntity> {
    public void setWorld(BaseWorld<E> world);
    // ...
}

interface ClientEntity extends BaseEntity<ClientEntity> {
    // ...
}