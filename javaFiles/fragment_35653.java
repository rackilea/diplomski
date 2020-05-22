@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="entityType",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue("TABLE_A")
public class ClassA {
     @Id
     private String id;

     @Column(name = "ATTRIBUTE_NAME")
     private String name;

     @Column(name = "ATTRIBUTE_VALUE")
     private String value;
}

@Entity
@DiscriminatorValue("TABLE_B")
public class ClassB extends ClassA { ... }