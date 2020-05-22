public <T> void someSortOfSort(List<T> polygons, Comparator<T> comparator){
    //Then for comparing elements.
    T a = ...
    T b = ...
    int r = comparator.compare(a,b);
    if(r>0){

    } else if( r<0){

    } else{
       //they're equal
    }
}