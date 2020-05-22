@Entity
@Table(name = "foo")
@SecondaryTable(name = "bar")
public class Foo {

    @Column(table = "bar")
    private String bar;

    (everything else)
}