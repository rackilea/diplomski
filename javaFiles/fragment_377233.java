class Whatever {
    private volatile boolean stop = false;
    ...
        while (!stop) {
            doALittleWork();
        }
    ...
}