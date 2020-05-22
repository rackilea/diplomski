public E remove(int index){
    E value =(E) elementData[index];
    for(int i=index;i<size-1;i++){
        elementData[i]=elementData[i+1];
    }
    elementData[size-1]=null;
    --size;  // Decrement size
    return value;
}