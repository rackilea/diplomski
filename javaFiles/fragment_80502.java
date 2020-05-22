@Entity
class A {
    public Integer id;
    public Integer bId;
}

@Entity
class B {
    public Integer id;
    public Integer cId;

    @OneToMany
    @JoinColumn(name="bId")
    private Set<A> a;
}

@Entity
class C {

    public Integer id;
    @ManyToOne
    public A a;

    @OneToMany
    @JoinColumn(name="cId")
    private Set<B> b;

}