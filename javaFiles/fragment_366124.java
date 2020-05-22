public class NameComparator implements Comparator<MyClass> {
    @Override
    public int compare (MyClass c1, MyClass c2) {
        return c1.getName().compareTo(c2.getName());
    }
}