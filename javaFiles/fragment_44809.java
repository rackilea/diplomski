public void get(Object[] objArr, Integer i){
    size = objArr.length;
    if(i<0 || i >= size){
       throw new IndexOutOfBoundsException("I must be greater than 0 and less than " + size);
    } 
}