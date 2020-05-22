@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer")
    private List<Skill> skills;
}

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private Long id;
    private String skillName;
    private byte skillLevel;
    @ManyToOne
    private Customer customer;
}