@Entity
@Table(name = "tableA")
@DiscriminatorColumn(name="`type`")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Base {
    ...
}

@Entity
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("A")
class A extends Base {
    ...
}

@Entity
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("B")
class B extends Base {
    ...
}