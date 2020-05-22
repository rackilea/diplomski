@MappedSuperclass
public class BaseEntity {
    ...
}

@MappedSuperclass
public class Person extends BaseEntity {
   ...
}

@Entity
@Table(name="OWNERS")
public class Owner extends Person {
    ...
}