<T> int combos(List<List<T>> inList) {
    int res = 1;
    for(List<T> list : inList) {
        res *= list.size();
    }
    return res;
}