while (true) {
    if (accounts[from] >= amount) {
        bankLock.lock();
        try {
            if (account[from] >= amount) {
                // do the transfer here...
                break;
            }
        } finally {
            bankLock.unlock();
        }
    }
}