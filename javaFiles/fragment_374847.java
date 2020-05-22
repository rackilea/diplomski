public class Tester {

    public static void main(String[] args) {
        checkGenericsOfLists();
    }

    public static void checkGenericsOfLists() {
        List<List<String>> listOfListOfStrings = createObject(
                new LinkedListFactory<List<String>>(),
                new LinkedListFactory<String>());
        transform(listOfListOfStrings);
    }

    public static List<List<String>> createObject(
            ListFactorable<List<List<String>>, List<String>> mainListFactory, 
            ListFactorable<List<String>, String> subListsFactory
    ) 
    {
        List<List<String>> listOfListOfStrings = mainListFactory.create();
        List<String> listOfStrings = subListsFactory.create();
        listOfStrings.add("A");
        listOfListOfStrings.add(listOfStrings);
        return listOfListOfStrings;
    }

    public static void transform(List<List<String>> listOfListOfStrings) {
        // do some abuse on the lists here.
        System.out.println(listOfListOfStrings);
    }

    public interface ListFactorable<T extends List<K>, K> {
        T create();
    }

    static public class LinkedListFactory<K> implements ListFactorable<List<K>, K> {
        public LinkedList<K> create() {
            return new LinkedList<K>();
        }
    }
}