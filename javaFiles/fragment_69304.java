@MappedSuperclass
public abstract class AbstractParent {
    public abstract List<CommonObject> getCommonObjects();
}

@Entity(name = "Child1")
public class Child1 extends AbstractParent {

    @Id
    private Long id;

    @OneToMany(targetEntity = CommonObject.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "child_1_common_objects", joinColumns = @JoinColumn(name="child1_id", nullable = false))
    @OrderColumn(name = "sort_index")
    private List<CommonObject> commonObjects = new ArrayList<>();

    public List<CommonObject> getCommonObjects() {
        return this.commonObjects;
    }
}

@Entity(name = "Child2")
public class Child2 extends AbstractParent {

    @Id
    private Long id;

    @OneToMany(targetEntity = CommonObject.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "child_2_common_objects", joinColumns = @JoinColumn(name="child2_id", nullable = false))
    @OrderColumn(name = "sort_index")
    private List<CommonObject> commonObjects = new ArrayList<>();

    public List<CommonObject> getCommonObjects() {
        return this.commonObjects;
    }
}

@Entity(name = "CommonObject")
public class CommonObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}