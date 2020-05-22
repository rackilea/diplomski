@Entity
class Parent {
    @EmbeddedId
    private ParentPk parentPk;

    @OneToMany
    @JoinColumns({ 
        @JoinColumn(name = "parentId", referencedColumnName = "parentId"), 
        @JoinColumn(name = "version", referencedColumnName = "version")
    })
    private List<ChildType1> children1;

    // exactly the same annotations as for children1
    private List<ChildType2> children2;

    // exactly the same annotations as for children1
    private List<ChildType3> children3;

    //..other fields and setters and getters
}

@Entity
class ChildType1 {
    @Id
    private Long childId;

    //..other fields and setters and getters
}

//--ChildType2 and ChildType3 like above