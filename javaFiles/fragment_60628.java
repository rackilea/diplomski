public class Contact{
 private String name;

public static final Comparator<Contact> BY_NAME_ASC = new Comparator<Contact>() {

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.name.compareTo(o2.name);
    }
};

}