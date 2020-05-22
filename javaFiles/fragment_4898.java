@SuppressWarnings("unchecked")  // This suppression is safe.
public Playground(int size, Class<T> clazz){
    this.size = size;
    pos = 0;
    arrayOfItems = (T[]) Array.newInstance(clazz, size);
}