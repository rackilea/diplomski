public class Account {
private Integer id;
private Something userData;

@OneToMany(mappedBy="account", cascade=CascadeType.ALL);
private Set<Mail> mails;

}