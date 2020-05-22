public boolean GreaterThanCAS(int newValue) {
    while(true) {
        int local = oldValue.get();
        if(newValue <= local) {
             return false; // swap failed
        }
        if(oldValue.compareAndSet(local, newValue)) {
             return true;  // swap successful
        }
        // keep trying
    }
}