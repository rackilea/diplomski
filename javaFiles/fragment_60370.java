private synchronized boolean tryEnter() {
    if (counter<5) {
        counter++;
        return true;
    }
    else {
        return false;
    }
}