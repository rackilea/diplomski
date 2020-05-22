public class Parent {

    @ManyToOne(optional=true)
    private Child child;

}

public class Child {

    @OneToMany
    private Set<Parent> parents;
}