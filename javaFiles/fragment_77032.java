@Entity
class Report {
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    User contributor;

    @ManyToOne
    User owner;

    SomeData data;
}