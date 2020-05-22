@Entity
public class Property {
    @Id @GeneratedValue private Long id;
}
@Entity
public class Uid_property {
    @Id @GeneratedValue private Long id;
    @ManyToOne
    Property property;
}