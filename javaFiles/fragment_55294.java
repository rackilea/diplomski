public ContentValues[] method1(...){
    synchronized (monitor1) {
        ...
    }
}

public ContentValues[] method2(...){
    synchronized (monitor2) {
        ...
    }
}