@Entity
@Table(name = "FOO")
public class Foo {

    @Basic
    private String bar;

    @Id
    @Column(name = "FOO_ID")
    @Type(type = "foo.bar.OracleGuidType")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    @OneToMany(mappedBy = "parentEntity", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Mapping> nestedFoos = new HashSet<>();

    @OneToMany(mappedBy = "childEntity", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Mapping> parentFoos = new HashSet<>();

    @Transient
    private Map<String, Foo> _nestedFoos = new HashMap<>();

    @Transient
    private Set<Foo> _parentFoos = new HashSet<>();

    @PostLoad
    @PostUpdate
    @PostPersist
    private void fillTransientFields() {
        _nestedFoos.clear();
        _parentFoos.clear();
        for (Mapping mapping : nestedFoos) {
            _nestedFoos.put(mapping.getMappingKey(), mapping.getChildEntity());
        }
        for (Mapping mapping : parentFoos) {
            _parentFoos.add(mapping.getParentEntity());
        }
    }

    public Map<String, Foo> geNestedFoos() {
        return Collections.unmodifiableMap(_nestedFoos);
    }

    public Set<Foo> getParentFoos() {
        return Collections.unmodifiableSet(_parentFoos);
    }

    public void addParent(String key, Foo parent) {
        Mapping mapping = new Mapping();
        mapping.setMappingKey(key);
        mapping.setChildEntity(this);
        mapping.setParentEntity(parent);
        parentFoos.add(mapping);
    }

    public void addChild(String key, Foo child) {
        Mapping mapping = new Mapping();
        mapping.setMappingKey(key);
        mapping.setChildEntity(child);
        mapping.setParentEntity(this);
        nestedFoos.add(mapping);
    }

    public void removeChild(String key) {
        for (Mapping mapping : nestedFoos) {
            if (mapping.getMappingKey().equals(key)) {
                nestedFoos.remove(mapping);
            }
        }
    }
}

@Entity
@Table(name = "FOO_MAPPING_TABLE",
        uniqueConstraints = {@UniqueConstraint(columnNames =
                {"MAPPING_KEY", "PARENT_ENTITY_ID"})})
class Mapping {

    @Basic
    @Column(name = "MAPPING_KEY")
    private String mappingKey;

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ENTITY_ID", nullable = false, updatable = false)
    private Foo parentEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHILD_ENTITY_ID", nullable = false, updatable = false)
    private Foo childEntity;
}