@Entity
@Table(name = "foo")
@NamedEntityGraph(name = "foo.bar",
        attributeNodes = @NamedAttributeNode("bar")
)
public class Foo {

    @ManyToOne(fetch = FetchType.LAZY)
    private Bar bar;

}

Foo foo = entityManager.find(
    Foo.class,
    id,
    Collections.singletonMap(
        "javax.persistence.fetchgraph",
        entityManager.getEntityGraph("foo.bar")
    )
);