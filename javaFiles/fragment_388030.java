public class Sack<E> {
    private final static int DEFAULT_CAPACITY = 10;
    private final static float REALLOC_FACTOR = 1.5f;
    private E[] elementData;
    private int size;

    public Sack() {
        this(DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public Sack(int capacity) {
        if(capacity <= 0)
            throw new IllegalArgumentException("capacity " + capacity);
        elementData = (E[]) new Object[capacity];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(E item) {
        int index = size++;
        if(size > elementData.length-1)
            elementData = Arrays.copyOf(elementData, (int)(size*REALLOC_FACTOR));
        elementData[index] = item;
    }
    public E [] dump() {
       E [] E2 = Arrays.copyOf(elementData, size);
       Arrays.fill(elementData, null);
       size = 0;
       return E2;
    }
    public E grab() {
        if(size == 0)
            return null;
        int index = (int)(Math.random()*size);
        E element = elementData[index];
        elementData[index] = elementData[size-1];
        elementData[size-1] = null;
        size--;
        return element;
    }
}