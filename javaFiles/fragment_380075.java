class Contact {
  public String name, lastname, address, number;

  public Contact(String name, String lastname, String address, String number) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.number = number;
  }

  public boolean equals(Contact c) {
    if(name.equals(c.name) && lastname.equals(c.lastname)
          && address.equals(c.address) && number.equals(c.number))
      return true;
    return false;
  }

  public String toString() {
    return name+","+lastname+","address+","+number+",";
  }
}

public class ContactDriver {
  public ArrayList<Contact> contacts = new ArrayList<Contact>();

  public static void addContact(Contact c) {
    contacts.add(c);
  }

  public static Contact deleteContact(Contact c) {
    return contacts.remove(c);
  }

  public static int searchContact(Contact c) {
    for(int i = 0; i < contacts.size(); i++)
      if(contacts.get(i).equals(c))
        return i;
    return -1;
  }

  public static void readContacts(String file) throws Exception {
    Scanner in = new Scanner(new File(file)).useDelimiter(",");

    while(in.hasNextLine()) {
      addContact(in.next(), in.next(), in.next(), in.next());
    }
  }

  public static void writeContacts(String fileName) {
    FileWriter dest = new FileWriter(fileName);

    for(Contact c : contacts)
      dest.write(c.toString());
  }

  public static void main() {
    readContacts();
    // Do logical stuffs
    writeContacts();
  }
}