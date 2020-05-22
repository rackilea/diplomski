@Entity
public class Parent implements Serializable {

    private MutableInt id = new MutableInt();

    private List<Child> childList = new ArrayList();

    @OneToMany(mappedBy="parent")
    @JoinColumn(name="PARENT_ID", insertable=false, updatable=false)
    @Cascade(CascadeType.SAVE_UPDATE)
    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id.intValue();
    }

    public void setId(Integer id) {
        this.id.setValue(id);
    }

    @Transient
    public MutableInt getIdAsMutableInt() {
        return id;
    }

    /**
     * Add convenience method 
     * 
     * A way to set up both sides (You have a bi-directional relationship, right ???)
     */
    public void addChild(Child child) {
        if(child.getChildId() == null)
            child.setChildId(new Child.ChildId());

        child.getChildId().setParentIdAsMutableInt(id);

        getChildList().add(child);

        child.setParent(this);
    }

}