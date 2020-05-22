// Using method reference (Java 8+)
public class PhoneBook {
    public PhoneBook(ArrayList<Name> names, ArrayList<Integer> phones) {
        this.directory = new TreeMap<Name, Integer>(PhoneBook::compareFirstName);
        // other constructor code
    }
    private static int compareFirstName(Name n1, Name n2) { // public, if reusable
        return n1.getFirstName().compareTo(n2.getFirstName());
    }
    // other PhoneBook code
}