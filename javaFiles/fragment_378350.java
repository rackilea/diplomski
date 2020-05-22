while(it.hasNext()){
    T next = it.next();     
    if(min.compareTo(next) > 0 ){
        min = next;
    }
}