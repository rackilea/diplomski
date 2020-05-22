public synchronized void addIfSpaceOrWait() {
    while (numOfAthletes >= 5) {
        wait();
    }
    numOfAthletes++;
}