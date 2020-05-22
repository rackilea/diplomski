Storage<K extends IHasKeys, V extends IHasValues> 
q = tab[index];
    while (q != null) {
        if (q.getKey().equals(key)) {
            K k = q.getKey();
            V v = q.getValue();
            return v;
        ...
    }