class SharedClass {
    private static int sharedData;

    public synchronized int getSharedData() {
        return sharedData;
    }

    public synchronized void incrementSharedData(int amount) {
        sharedData += amount;
    }
}