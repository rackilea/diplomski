@Override
    protected String transform(String originalLogString) {
        if (doNotLog) {
            return null;
        }
        return originalLogString;
    }