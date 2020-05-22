public class User{    

@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="user")
private Set<Account> accounts; 

}