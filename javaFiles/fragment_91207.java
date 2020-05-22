@MappedSuperclass
public class Common {
    @Id
    private Integer id;
}

@Entity
@Table(name = "A")
public class A extends Common {
    ...
}

@Entity
@Table(name = "B")
public class B extends Common {
    ...
}