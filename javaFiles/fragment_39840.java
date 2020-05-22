@Entity
public class AccountPool {

     @OneToMany
     @Where( clause = "deleted='false'" )
     private List<Account> accounts;
}