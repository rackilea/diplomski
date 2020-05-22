@Entity
@Table(name="TEST")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Test {
    ...
}

@Entity
public class ExtendedTest 
    extends Test {
    ...
}