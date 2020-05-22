public class B {
    @OneToMany(mappedBy = "b");
    private Collection<A> as;

    @Id
    @Column(name = "B_ID")
    private Long id;
}

public class A {
    @ManyToOne
    @JoinColumn(name = "B_ID");
    private B b;
}