public class SomeClass<T> {
    private T it;

    public T getIt() {
        return it;
    }

    public void setIt(T it) {
        this.it = it;
    }
}

public static void main(String...args) {
    SomeClass<String> someClass = new SomeClass<String>();
    someClass.setIt("this is it!");
    System.out.println(someClass.getIt());
}