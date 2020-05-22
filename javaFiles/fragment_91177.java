public static int linearSearch(String name) {
    for (int i = 0; catalogue[i] != null; i++) {
        if (name.equals(catalogue[i].getName())) {
            return catalogue[i].getNumber();       // <--- return early if match found
        }
    }
    return -1;                                     // <--- return -1 for no match 
}