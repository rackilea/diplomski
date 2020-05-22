public class ClassA<R extends ClassA<R>> { // note the recursive nature
    public ArrayList<String> v1 = new ArrayList<>();

    @SuppressWarnings("unchecked")
    protected R self() {
      return (R) this;
    }

    public R addOnce(String s1) {
        v1.add(s1);
        return self();
    }
}