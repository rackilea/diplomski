if ( hash.containsKey(a[i]) ) {
    if (!hash.get(a[i])) {
        hash.put(a[i], true);
    }
} else {
    hash.put(a[i], false);
}