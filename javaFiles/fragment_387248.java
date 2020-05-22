public static <T> T nextElement(List<T> list,T element){
    int nextIndex=list.indexOf(element)+1;
    return list.size()<nextIndexlist?null:list.get(nextIndex);

}

public static <T> T previousElement(List<T> list,T element){
     int previousIndex=list.indexOf(element)-1;
     return list.size()>previousIndexlist?null:list.get(previousIndex);

}