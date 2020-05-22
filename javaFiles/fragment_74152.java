@MappedSuperclass
public abstract class GenericHierarchicalDictionary {

    public abstract GenericHierarchicalDictionary getParent();

    public abstract Set<? extends GenericHierarchicalDictionary> getChildren();

}

@Entity
@Table(name = "LocalFolder")
public class LocalFolder extends GenericHierarchicalDictionary {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LocalFolder parent;

    @OneToMany(mappedBy = "parent")
    private Set<LocalFolder> children = new HashSet<LocalFolder>();

    @Override
    public LocalFolder getParent() {
        return parent;
    }

    @Override
    public Set<LocalFolder> getChildren() {
        return children;
    }

    public void addChild(LocalFolder localFolder) {
        localFolder.parent = this;
        children.add(localFolder);
    }
}

@Entity
@Table(name = "RemoteFolder")
public class RemoteFolder extends GenericHierarchicalDictionary {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RemoteFolder parent;

    @OneToMany(mappedBy = "parent")
    private Set<RemoteFolder> children = new HashSet<RemoteFolder>();

    @Override
    public RemoteFolder getParent() {
        return parent;
    }

    @Override
    public Set<RemoteFolder> getChildren() {
        return children;
    }

    public void addChild(RemoteFolder localFolder) {
        localFolder.parent = this;
        children.add(localFolder);
    }
}