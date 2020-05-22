@Embeddable
public classs Common {
    @Basic 
    private int foo;
    ...
}

@Entity
public class B extends A {
    @Embedded
    private Common common;
    ...
}