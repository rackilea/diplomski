@AttributeOverrides({
        @AttributeOverride(name = "i1", column = @Column(name = "i1")),
        @AttributeOverride(name = "i2", column = @Column(name = "i2"))
})
@Embedded
Nested nested;