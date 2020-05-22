public boolean putIfAbsent(E x) {  
    synchronized (list) {
        boolean absent = !list.contains(x);  
        if (absent) { 
            list.add(x);  
        }
        return absent;
    }
}