@Entity
@Table(name = "some_entity")
public final class SomeEntity {

    @Column(nullable = false, unique = true, length = 20)
    private String externalId;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId", nullable = true)
    private SomeEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<SomeEntity> children; //or Set<>

    //returns direct children
    public List<SomeEntity> getChildren(){
        return children;
    } 

    //returns all children to any level
    public List<SomeEntity> getAllChildren(){
        getAllChildren(this);
    }

    //recursive function to walk the tree
    private List<SomeEntity> getAllChildren(SomeEntity parent){
        List<SomeEntity> allChidren = new ArrayList<>();

        for(SomeEntity child : children){
            allChildren.add(child);
            allChildren.addAll(getAllChildren(child);
        }

        return allChildren;
    }
}