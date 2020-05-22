public class ObjectA {
    private ArrayofObjectA arrA;

    public ObjectA(ArrayofObjectA a) {
      this.arrA = a; ///'this' is optional but makes it clear we are talking about a member field.
    }

    public void doThis(ArrayofObjectA arrA) {
        this.arrA.doSomething(); // <-- Here's the issue
    }
}