@Entity
@Table(name = "a")
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    @Where(clause = "blah = 'CONSTANT_VALUE'")
    public Set<B> b;

    protected A() {}
}

@Entity
@Table(name = "b")
public class B {
    @Id
    @Column(nullable = false)
    public Long id;

    @Column(nullable = false)
    public String blah;

    protected B() {}
}