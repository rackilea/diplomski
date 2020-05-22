@Entity
@Table(name = "table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class ParentImpl implements Parent{}

@Entity
@DiscriminatorValue("1")
public class Entity1Impl extends ParentImpl {}

public interface AbstractDao<T extends Parent> {}

public interface ConcreteParentDao<Parent> {}