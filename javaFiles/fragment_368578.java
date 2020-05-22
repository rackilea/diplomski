public <T> int getOccurrenceIndex(List<T> list, T o){
    T tmp;
    for(int i=0; i<list.size(); i++){
        tmp = list.get(i);
        if(tmp.equals(o)){
            return i;
        }
    }
    return -1;
}