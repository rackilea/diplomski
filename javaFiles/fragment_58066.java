@Entity
public class Contact {
  @Id
  private Long id;

  @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "contact")
  private List<Phone> phoneNumbers;

  public void addPhone(PhoneNumber phone) {
     if (phone != null) {
        if (phoneNumbers == null) {
            phoneNumbers = new ArrayList<Phone>();          
        }
        phoneNumbers.add(phone);
        phone.setContact(this);
     }
  }

  ...
}

@Entity
public class Phone {
  @Id
  private Long id;

  @ManyToOne
  private Contact contact;

  ...
}