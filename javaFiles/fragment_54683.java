public static<T> List<T> append (List<T[]> input) {
    List<T> res = new ArrayList<T>();
    for(T[] subarr : input) {
        if(subarr != null) {
            int n = subarr.length;
            for(int i = 0; i < n; i++) {
                res.add(subarr[i]);
            }
        }
    }
    return res;
}