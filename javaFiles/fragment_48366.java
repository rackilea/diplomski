AtomicBoolean initStarted = new AtomicBoolean();
volatile boolean initDone = false;
Thing thing = null;

public Thing getThing() {
    // only the 1st ever call will do this
    if (initStarted.compareAndSet(false, true)) {
        thing = init();
        initDone = true;
        return thing;
    }

    // all other calls will go here
    if (initDone) {
      return thing;
    } else {
        // you're stuck in a pretty undefined state
        return null;
    }
}
public boolean isInit() {
    return initDone;
}
public boolean needsInit() {
    return !initStarted.get();
}