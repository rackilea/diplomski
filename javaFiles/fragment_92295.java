public class NameSort implements Comparator<Person> {
    @Override
    public int compare(Person arg0, Person arg1) {
        int result = arg0.get_Name().compareToIgnoreCase(arg1.get_Name());
        if (result == 0) {
            return arg0.get_FamilyName().compareToIgnoreCase(
                    arg1.get_FamilyName());
        } else {
            return result;
        }
    }
}