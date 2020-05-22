public class Entity1 {

    @ManyToMany
    @JoinTable(
        name="LINK_TABLE_NAME",
        joinColumns=@JoinColumn(name="ENTITY1_ID", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="ENTITY2_ID", referencedColumnName="ID"))
    private List<Entity2> entities2;
}

public class Entity2 {

    @ManyToMany(mappedBy="entities2")
    private List<Entity1> entities1;
}