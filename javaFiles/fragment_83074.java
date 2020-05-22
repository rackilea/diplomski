public boolean func1(long duration) {
    long t = System.currentTimeMillis();
    while (System.currentTimeMillis() - t < duration) {
        if (isdateok())
            return true;
        else
            Thread.yield();
    }
    return false;
}