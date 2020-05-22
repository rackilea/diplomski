public class IntCollection2 {

    private int[] collection; // A large allocation, not neccessarily filled up.
    private int currentSize; // The number of spots currently filled in the collection.

    public IntCollection2() {

        collection = new int[500];
        currentSize = 0;

    }

    public IntCollection2(int size) {

        collection = new int[size];
        currentSize = 0;

    }

    /**
     * Inserts a new element into the internal array. If the current array is filled up,
     * a new array double the size of the current one is allocated.
     * @param element An int to insert into the collection. Must not be '0'.
     * @return True if the element was successfully inserted, false if the element was
     *         equal to '0' and was ignored.
     */
    public boolean insert(int element) {

        if (element != 0) {

            if (currentSize < collection.length - 1) {

                collection[currentSize] = element;

            } else {

                int[] newCollection = new int[collection.length * 2];

                for (int i = 0; i < currentSize; i++) {

                    newCollection[i] = collection[i];

                }

                newCollection[currentSize] = element;
                collection = newCollection;

            }

            currentSize++;
            return true;

        } else {

            return false;

        }

    }

    /**
     * Not actually necessary because the class automatically updates its currentSize
     * every time a new element is inserted.
     * @return The current number of filled spots in the internal array.
     */
    public int getCurrentSize() {

        int size = 0;

        for (int i = 0; i < collection.length && collection[i] != 0; i++) {
            size++;
        }

        return size;

    }

    /**
     * Prints out all the elements currently in the collection, one on each line.
     */
    public void print() {

        System.out.println();

        for (int i = 0; i < currentSize; i++) {

            System.out.println(collection[i]);

        }

    }

}