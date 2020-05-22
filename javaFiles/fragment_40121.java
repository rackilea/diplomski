public synchronized boolean putIfAbsent(E x) {  
    boolean absent = !list.contains(x);  
    // <<--- the Thread A call could happen here.
    if (absent)  {
        list.add(x);  
    }
    return absent;  
}