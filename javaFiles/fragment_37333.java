@Entity
@Table(name = "foo")
@FetchProfile(
    name = "foo.bar",
    fetchOverrides = {
        @FetchProfile.FetchOverride(
            entity = Employee.class,
            association = "projects",
            mode = FetchMode.JOIN
        )
    }
)
public class Foo {
    @ManyToOne(fetch = FetchType.LAZY)
    private Bar bar;
}


session.enableFetchProfile("foo.bar");
Foo foo = session.byId(Foo.class).load(id);