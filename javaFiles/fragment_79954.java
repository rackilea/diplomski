public class ClassA {

    public ArrayList<String> v1 = new ArrayList<>();

    public ClassA addOnce(String s1) {
        v1.add(s1);
        return this;
    }

}
public class ClassB extends ClassA {

    public ClassB addOnce(String s2) {
        super.addOnce(s2);
        return this; // same reference as in the super method, but now typed to ClassB
    }
    ...

}