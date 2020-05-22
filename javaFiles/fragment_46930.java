public class MyClass extends MyAbstractClass {
    // ...

    public Iterator<SomeoneElsesInterface> iterator() {
      return Arrays.<SomeoneElsesInterface>asList(things).iterator();
    }
}