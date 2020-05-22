public class MyArray implements Iterable<Integer> {

    public static class MyIterator implements Iterator<Integer> {

        private final MyArray myArray;
        private int current;

        MyIterator(MyArray myArray) {
            this.myArray = myArray;
            this.current = myArray.start;
        }

        @Override
        public boolean hasNext() {
            return current < myArray.end;
        }

        @Override
        public Integer next() {
            if (! hasNext())   throw new NoSuchElementException();
            return myArray.arr[current++];
        }

        @Override
        public void remove() {
            // Choose exception or implementation: 
            throw new OperationNotSupportedException();
            // or
            //// if (! hasNext())   throw new NoSuchElementException();
            //// if (currrent + 1 < myArray.end) {
            ////     System.arraycopy(myArray.arr, current+1, myArray.arr, current, myArray.end - current-1);
            //// }
            //// myArray.end--;
        }
    }

    ....

    // Most of the rest of MyArray is the same except adding a new iterator method ....

    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    // The rest of MyArray is the same ....

}