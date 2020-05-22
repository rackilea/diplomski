@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "field", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("dummy")
public class EntitySuperClass {
    // here definitions go 
    // but don't define discriminator column here
}

@Entity
@DiscriminatorValue(value="sub1")
public class Sub1Class extends EntitySuperClass {
    // here definitions go
}