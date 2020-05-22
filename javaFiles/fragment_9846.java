private class WriteTask extends TimerTask {
    ReentrantLock activeStatementsLock = new ReentrantLock();

    //...keep the rest the same

    public ArrayList<WriteStatement> getActiveStatements() {
        synchronized (activeStatementsLock) {
            return writeData;
        }
    }
}