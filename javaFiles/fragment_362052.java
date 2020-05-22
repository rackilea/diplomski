public static RuntimeDelegate getInstance() {

        RuntimeDelegate result = cachedDelegate;
        if (result == null) { // First check (no locking)
            synchronized (RD_LOCK) {
                result = cachedDelegate;
                if (result == null) { // Second check (with locking)
                    cachedDelegate = result = findDelegate();
                }
            }
        }
        return result;
    }