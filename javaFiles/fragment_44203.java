public static <T> T firstNonEmptyValue(T[] array){
    for(T element : array){
        if (element != null)
            return element;// return first element that is not null
    }
    // if we are here it means that we iterated over all elements 
    // and didn't find non-null value so it is time to return null
    return null;
}