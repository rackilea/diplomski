@Entity 
@Table(name = "criteria") 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = AbstractCriteria.TYPE, discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractCriteria implements Serializable {

  public static final String TYPE = "type";

  ...
  @Column(name = "clazz") private Class clazz;
  ...

  protected AbstractCriteria(Class clazz) {
     this.clazz = Preconditions.checkNotNull(clazz);
  }
  ...

  public abstract Predicate evaluate(Object value);
}

@Entity 
@DiscriminatorValue(CriteriaType.Values.DATETIME_IS_BETWEEN) 
public class DateTimeIsBetweenCriteria extends AbstractCriteria {
  ...
  public DateTimeIsBetweenCriteria() {
     super(DateTime.class);
  }
  ...


  @Override 
  public Predicate evaluate(Object value) {
     if (value instanceof DateTime) {
        // do evaluation and return here.
     } else {
        throw new UserDefinedException("...");
     }
  }
}