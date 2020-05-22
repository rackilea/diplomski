@Entity(name = "Foo")
@Table(name = "FOO")
public class Foo implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@Column(name = "ID")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOO_SEQ")
private Long id;

@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "foo", orphanRemoval = true)
@EqualsAndHashCode.Exclude
private Set<FooBarStatus> fooBarStatus;
}