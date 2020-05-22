/** User model **/
@Entity
@Table(name = "user")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id", unique = true, nullable = false)
private int id;

@Column(name = "type")
private String type;

@Column(name = "username", nullable = false)
private String username;

...

// FetchType should be Lazy to improve performance

@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="user")
private Set<Account> accounts;
//mappedBy says that this side is inverse side of relation and source is user which is mapped by user field name in Account class

public User() {
}

@PrePersist
void preInsert() throws ParseException {
    ...
}

// field getters and setters

...

// returns Account list associated with User
public Set<Account> getAccount() { 
    return accounts; 
} 

// set Account list associated with User
public void setAccount(Set<Account> accounts) { 
    this.accounts = accounts; 
}
}