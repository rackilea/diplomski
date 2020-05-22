@Entity
@Table(name="MAG")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Magazine {
    ...
}

@Entity
@Table(name="TABLOID")
public class Tabloid
    extends Magazine {
    ...
}