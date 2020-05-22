atomicValue = map.get(key);
while (true) {
    value = atomicValue.get();
    if (value < myThreadNumber) {
        if (value.compareAndSet(value, myThreadNumber) {
            // successfully increased the thread number
            triggerUpdate();
            break;
        } // else value update failed, loop back to try again.
    } else {
        break;
    }
}