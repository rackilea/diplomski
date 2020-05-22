@Embeddable
public class EntityPropertyPK {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private Entity entity;

    ...
}

@Entity 
@Table(name="entity_property") 
public class EntityProperty { 
    @EmbeddedId
    private EntityPropertyPK id;

    @Column(name = "value")
    private String value; 

    ...
}