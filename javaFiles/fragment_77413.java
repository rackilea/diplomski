public class SomeClass<T extends List<Integer>> {
    public  void main(String[] args) {
        String s = newList(); // this doesn't compile anymore
        System.out.println(s);
    }

    private T newList() {
        return (T) new ArrayList<Integer>();
    }
}