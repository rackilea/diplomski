public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");
        MementoListIterator<String> mementoListIterator = new MementoListIterator<String>(
                list);

        Memento initialState = mementoListIterator.save();

        while (mementoListIterator.hasNext()) {
            String string = mementoListIterator.next();
            System.out.println(string);
        }
                    // Normally we can not re-use the iterator, but
                    // fortuanatly we saved the initial state.

        // restore the initial state and we can use the Iterator again
        mementoListIterator.restore(initialState);

        while (mementoListIterator.hasNext()) {
            String string = mementoListIterator.next();
            System.out.println(string);
        }
    }
}