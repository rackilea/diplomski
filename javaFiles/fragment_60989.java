run(running){
...
    synchronized(set) {
        set.add(obj);
    }
...
}