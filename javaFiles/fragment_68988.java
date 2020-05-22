@Entity 
public class AnEntity {
    @OneToMany
    @JoinColumn("aentity_id")
    @MapKey(name = "name")
    private Map<String, Property> properties;
    ...
    public getPropertyA() {
        return properties.get("propertyA");
    }
    ...
}