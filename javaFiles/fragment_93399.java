@Entity
@Table(name = "USER")
public class User {

@Id
@Column(name = "ID")
private Long id;

@ManyToMany
@JoinTable(name = "USER_PERMISSIONS", 
    joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), 
    inverseJoinColumns = @JoinColumn(name = "PERM_ID", referencedColumnName = "ID"))
private Collection<Permissions> permissions;