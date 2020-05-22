@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
  ...
}

@Entity
public class Customer extends Person {
  ...
}

@Entity
public class Supplier extends Person {
  ...
}