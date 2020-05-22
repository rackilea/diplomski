class Bar {
    @EmbeddedId
    private BarPK primaryKey;

    @ManyToOne
    @MapsId("id")
    private Foo foo;
}