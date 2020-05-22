public static <T, L extends List<? extends T> & RandomAccess> void method(L list) {
    // do whatever
}

@SuppressWarnings("unchecked") // needed to suppress unsafe cast warning 
public static <T, L extends List<? extends T> & RandomAccess> void method(Iterable<? extends T> iterable) {
    if(iterable instanceof List && iterable instanceof RandomAccess)
        method((L)iterable); // calls the other method
    else
        return; // do whatever
}