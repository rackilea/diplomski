void update() {
     synchronized (lock) {
        if (isZero) {
             isZero = false;
             counter++;
        } else {
             isZero = true;
             counter--;
        }
    }
}