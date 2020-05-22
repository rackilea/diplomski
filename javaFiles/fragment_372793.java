public class Main {
    public static void main(String[] args) {
        final LinkedList<String> list = new LinkedList<String> ();

        list.add ("1"); list.add ("2"); list.add ("3"); list.add ("4");

        final MyIterator<String> it = new MyIterator (list.listIterator());

        System.out.println(it.next());
        System.out.println(it.next ());
        System.out.println(it.next ());
        System.out.println(it.previous ());
        System.out.println(it.previous ());
        System.out.println(it.next ());
    }

    public static class MyIterator<T> {

        private final ListIterator<T> listIterator;

        private boolean nextWasCalled = false;
        private boolean previousWasCalled = false;

        public MyIterator(ListIterator<T> listIterator) {
            this.listIterator = listIterator;
        }

        public T next() {
            nextWasCalled = true;
            if (previousWasCalled) {
                previousWasCalled = false;
                listIterator.next ();
            }
            return listIterator.next ();
        }

        public T previous() {
            if (nextWasCalled) {
                listIterator.previous();
                nextWasCalled = false;
            }
            previousWasCalled = true;
            return listIterator.previous();
        }

    }   
}