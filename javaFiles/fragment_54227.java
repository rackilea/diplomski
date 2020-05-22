public void insert(Element e) {
    size = heapSize(eList);
    eList[size] = e;
    decreaseKey(eList, size, e.key);
}

public void decreaseKey(Element[] array, int i, int key){
    array[i].key = key;
    while (i > 0 && array[parent(i)].key > array[i].key){
        swap(array,i,parent(i));
        i = parent(i);
    }
}