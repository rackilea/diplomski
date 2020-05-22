public class HelloWorld {
public static void main(String... args) {
    int size = 5;
    History<Integer> history = new HelloWorld().new History<>(size);
    for (int i = 0; i < size; ++i) {
        history.add(Integer.valueOf(i));
    }

    for (Integer a : history) {
        System.out.println(a);
        if (a % 3 == 1) {
            System.out.println(history.iterator().previous());
        }
    }
}

class History<T> implements Iterable<T> {
    T[] arr;
    int index;

    public History(int theSize) {
        index = -1;
        arr = (T[]) new Object[theSize];
    }

    public void add(T t) {
        arr[++index] = t;
    }

    @Override
    public ListIterator iterator() {
        return new ListIterator() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i <= index;
            }

            @Override
            public Object next() {
                return arr[i++];
            }

            @Override
            public boolean hasPrevious() {
                return i > 0;
            }

            @Override
            public Object previous() {
                return arr[i - 1];
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(Object o) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(Object o) {
                throw new UnsupportedOperationException();
            }
         };
      }
   }
}