public class SomeClass<T extends List<Integer>> {
    public <X extends String&List<Integer>> void main(String[] args) {
        String s = new SomeClass<X>().newList();
        System.out.println(s);
    }

    private T newList() {
        return (T) new ArrayList<Integer>();
    }
}