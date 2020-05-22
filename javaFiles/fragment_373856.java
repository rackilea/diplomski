@Entity
@Table(name = "A")
public class A {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int a_id;

    @ElementCollection
    @JoinTable(name = "embeded_class_table", joinColumns = @JoinColumn(name = "a_id"))
    private List<EmbeddableClass> embeddedClass;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public List<EmbeddableClass> getEmbeddedClass() {
        return embeddedClass;
    }

    public void setEmbeddedClass(List<EmbeddableClass> embeddedClass) {
        this.embeddedClass = embeddedClass;
    }

}

@Entity
@Table(name = "B")
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int b_id;
}

@Embeddable
public class EmbeddableClass {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "b_id")
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }


}