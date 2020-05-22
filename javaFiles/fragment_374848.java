public class Tester2 {
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
            ListFactory<List<String>> mainListFactory, 
            ListFactory<String> subListsFactory
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

    public interface ListFactory<T> {
        List<T> create();
    }

    static public class LinkedListFactory<T> implements ListFactory<T> {
        public List<T> create() {
            return new LinkedList<T>();
        }
    }
}