@Entity
Class C {
    @ManyToOne(cascade=CascadeType.ALL)
    private A a;

    @ManyToOne(cascade=CascadeType.ALL)
    private B b;
}