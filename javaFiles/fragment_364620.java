@Entity
public class Property {
    @Id @GeneratedValue private Long id;
    @OneToMany(mappedBy="property")
    private Set<Uid_property> uid_properties;
}
// This hasn't changed
@Entity
public class Uid_property {
    @Id @GeneratedValue private Long id;
    @ManyToOne
    private Property property;
}