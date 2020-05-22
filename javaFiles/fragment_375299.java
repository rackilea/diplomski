map.compute(key, (key, value) -> {
    if (value < myThreadNumber) {
        triggerUpdate();
        return myThreadNumber;
    }
    return value; // no changes
})