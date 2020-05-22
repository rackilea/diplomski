public static int compareObjects(Comparable a, Comparable b){

    if (a == null && b == null){
        return 0;
    } else if (a == null){
        return -1;
    } else if (b == null){
        return 1;
    } else {
        return a.compareTo(b);
    }
}