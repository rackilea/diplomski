@Entity @IdClass(ParentId.class)
class Parent {
    @Id int someCode
    @Id Date someDate
    @Id int someId

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns([@JoinColumn(name = "someCode"),
        @JoinColumn(name = "someDate"),
        @JoinColumn(name = "someId")])
    Set<Child> children
}