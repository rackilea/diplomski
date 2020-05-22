boolean runWithRetries(int maxRetries, ThrowingTask t) { 
    int count = 0;
    while (count < maxRetries) {
        try {
            t.run();
            return true;
        }
        catch (ExecutionException e) {
            if (++count >= maxRetries)
                return false;
        }
    }
}