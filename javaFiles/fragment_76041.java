for (int i = 0, size = stripes.size(); i++; i < size) {
    stripes.getAt(i).lock();
}
try {
    // Do something
} finally {
    for (int i = 0, size = stripes.size(); i++; i < size) {
        stripes.getAt(i).unlock();
    }
}