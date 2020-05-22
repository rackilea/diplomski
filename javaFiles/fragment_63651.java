class Foo {
    @EmbeddedId
    private FooPK primaryKey;

    @OneToMany(mappedBy="foo")
    private List<Bar> bars;
}