m1(C obj) {
    synchronized(this) {
        obj.m2();
    }
}

m2() {
    synchronized(this) {
        // some stuff
    }
}