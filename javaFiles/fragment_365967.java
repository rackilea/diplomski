@Entity
@Table(name = "account", uniqueConstraints =
@UniqueConstraint(columnNames = {"user_id", "entity_id", "branch_id", "type"}))
public class Account {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id", nullable = false)
private int id;

@Column(name = "user_id", nullable = false)
private int user_id;

...
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "user_id", insertable = false, updatable = false)
private User user; 

// constructor
public Account() {

}

@PrePersist
void preInsert() throws ParseException {       
    ...
}

// field getters and setters

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}

...

// define many to one relation between Account and User

// get User associated with Account


public User getUser() { 
    return user; 
} 

// set User associated with Account
public void setUser(User user) { 
    this.user = user; 
}
}