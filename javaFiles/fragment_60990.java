synchronized(set) {
    for (Iterator<MyObject> i = set.iterator(); i.hasNext();) {
        MyObject obj= i.next();
        if (!obj.isSmt()) {
            i.remove();
           ...
        }
    }
}