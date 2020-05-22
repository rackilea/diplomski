class WeirdIndexArray<T> {
    private final T[] internalArray;
    public final int firstIndex;
    public final int indexBound;
    public WeirdIndexArray( int firstIndex, int size ){
        internalArray = new T[size];
        this.firstIndex = firstIndex;
        indexBound = firstIndex+size;
    }
    public void set( int index, T item ){ internalArray[index-firstIndex] = item; }
    public T get( int index ){ return internalArray[index-firstIndex]; }
}