private HashSet<Host> hosts;
    private HashSet<Host> immune;
    private HashSet<Host> infectious;

    public void killHost(Host deadManWalking) {
        hosts.remove(deadManWalking);
        immune.remove(deadManWalking);
        infectious.remove(deadManWalking);
    }