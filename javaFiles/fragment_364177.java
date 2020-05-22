@Entity
public class Account {
    @Id @GeneratedValue
    public Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account", orphanRemoval = true)
    public List<Contact> contacts = new ArrayList<Contact>();

    public void addToContacts(Contact contact) {
        this.contacts.add(contact);
        contact.setAccount(this);
    }

    public void removeFromContacts(Contact contact) {
        this.contacts.remove(contact);
        contact.setAccount(null);
    }

    // getters, setters
}