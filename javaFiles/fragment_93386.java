@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany(mappedBy="entities")
    private Set<Survey> surveys = new HashSet<Survey>();
    ...

}

@Entity
public class User extends AbstractEntity {
    ...
}

@Entity
public class Group extends AbstractEntity {
    ...
}

@Entity
public class Survey {
    @Id @GeneratedValue
    private Long id;

    @ManyToMany
    private Set<AbstractEntity> entities = new HashSet<AbstractEntity>();

    ...
}