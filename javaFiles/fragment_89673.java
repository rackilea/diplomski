public class InMemoryRepository implements Repository {
    @Override
    List<String> getAllStrings() {
        // you can create this list as static list in constructor if you are not sure that it is really singleton :)
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        return list;
    }
}