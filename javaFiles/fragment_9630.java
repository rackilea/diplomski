@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private Department department;
}

@Getter
@Setter
@Entity
public class Department {
    @Id // Note no generation
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "department_belongs_to_person"))
    private Person person;
}