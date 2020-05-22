// This will all compile
public void doSomethingWith(List<? extends Number> numbers) {
    for (Number number : numbers) {
        // Do something with number
    }
    // OR
    Number number = numbers.get(0);
    // OR
    Number number = numbers.remove(0);
}