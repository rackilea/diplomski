@Entity
public class A {
    @Id
    private Long id;
    private Long data;

    @ElementCollection
    @CollectionTable(name="A_CONF", joinColumns=@JoinColumn(name="A_ID")) // A_ID would be the default join column
    @Column(name="INFO")
    private Set<String> infos; // using Set assuming unique values
}