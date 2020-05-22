public class Parent {
    @Id
    private Integer id;

    @OneToMany(mappedBy = "parent")
    @MapKey(name = "key")
    private Map<String, KeyValuePair> keyValuePairs;
}

public class KeyValuePair {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;
}