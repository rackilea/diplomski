import java.util.*;

public class Example {
    static String lastName(String fullName) {
        return fullName.substring(fullName.indexOf(' ') + 1);
    }
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<String,String>();
        map.put("001", "John Doe");
        map.put("666", "Anti Christ");
        map.put("007", "James Bond");

        System.out.println(map);
        // "{001=John Doe, 007=James Bond, 666=Anti Christ}"
        // Entries are sorted by keys!

        // Now let's make a last name Comparator...
        Comparator<String> lastNameComparator = new Comparator<String>() {
            @Override public int compare(String fullName1, String fullName2) {
                return lastName(fullName1).compareTo(lastName(fullName2));
            }
        };

        // Now let's put all names in a SortedSet...
        SortedSet<String> namesByLastName =
            new TreeSet<String>(lastNameComparator);
        namesByLastName.addAll(map.values());

        System.out.println(namesByLastName);
        // "[James Bond, Anti Christ, John Doe]"
        // Names sorted by last names!

        // Now let's use a List instead...
        List<String> namesList = new ArrayList<String>();
        namesList.addAll(map.values());
        System.out.println(namesList);
        // "[John Doe, James Bond, Anti Christ]"
        // These aren't sorted yet...

        Collections.sort(namesList);
        System.out.println(namesList);
        // "[Anti Christ, James Bond, John Doe]"
        // Sorted by natural ordering!

        // Now let's sort by string lengths...
        Collections.sort(namesList, new Comparator<String>() {
            @Override public int compare(String s1, String s2) {
                return Integer.valueOf(s1.length()).compareTo(s2.length());
            }
        });
        System.out.println(namesList);
        // "[John Doe, James Bond, Anti Christ]"
        // SUCCESS!!!
    }
}