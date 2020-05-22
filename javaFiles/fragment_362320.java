String peekSpot(Queue<String> queue, Integer index){
    if(queue == null){
        throw new IllegalArgumentException();
    }
    Object[] array = queue.toArray();
    return (String)array[index];
}