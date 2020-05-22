@MappedSuperclass
public abstract class BaseEntity {

    //common attributes, getters/setters, whatever
}

@Entity
@Table(name = "firstTable")
public class ConcreteEntity extends BaseEntity {

    //anything specific to this class, if at all. Can be completely empty
}

@Entity
@Table(name = "secondTable")
public class AnotherConcreteEntity extends BaseEntity {

    //anything specific to this class, if at all. Can be completely empty
}