@EntityListeners({ParentJpaCallbacksListener.class})
@Entity
public class Parent implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "parent")
    private Set<Child> children;
}