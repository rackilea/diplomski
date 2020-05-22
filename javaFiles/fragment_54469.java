public class ArrayObjects<E> implements SomeImp<E> {
    int maxCapacity, actualSize;
    E[] array; // <- The missing declaration

    @SuppressWarnings("unchecked") // <- Suppress the "unchecked cast" warning
    public ArrayObjects() {
        maxCapacity = 10;
        array = (E[]) new Object[maxCapacity];
    }
}