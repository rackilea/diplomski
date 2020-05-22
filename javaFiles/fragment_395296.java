@Entity
@Table(name = "accounts")
public class Account
{
    protected String accountId;
    protected Collection<Contact> contacts;

    @Transient
    public Collection<Contact> getContacts()
    {
        return contacts;
    }

    //getters & setters

}