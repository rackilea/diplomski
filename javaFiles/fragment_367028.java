@Entity
public class EntityA {
    @GeneratedValue (strategy = GenerationType.TABLE)
    @Id public int id;
    @OneToMany(mappedBy = "a")
    public List<EntityB> bList;
     ...
}

@Entity
public class EntityB {
    @GeneratedValue (strategy = GenerationType.TABLE)
    @Id
    public int id;

    @ManyToOne
    private EntityA a;
}