@Entity
class A {
    public Integer id;

    @ManyToOne
    public B b;
}

@Entity
class B {
    public Integer id;

    @ManyToOne
    public C c;
}

@Entity
class C {
    public Integer id;

    @ManyToOne
    public A a;
}