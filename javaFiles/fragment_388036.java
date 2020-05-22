if(areHashMapValuesEqual(hashMap.values(),hashMap2.values())){
        return true;
    } else {
        return false;
    }

  static <T> boolean areHashMapValuesEqual(Collection<T> lhs, Collection<T> rhs) {
    boolean equals = false;
    if(lhs!=null && rhs!=null) {
        equals = lhs.size( ) == rhs.size( ) && lhs.containsAll(rhs)  && rhs.containsAll(lhs);
    } else if (lhs==null && rhs==null) {
        equals = true;
    }
    return equals;
}