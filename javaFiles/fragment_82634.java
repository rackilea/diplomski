Set<Integer> tracker = new HashSet<>();

public boolean checkID(int numToCheck) {
    return tracker.contains(numToCheck);
}

public boolean takeID(int numToTake) {
    if(!checkID(numToTake)) {
        tracker.add(numToTake);
        return true;
    }
    return false;
}

public void releaseID(int numToRelease) {
    if(checkID(numToRelease)) {
        tracker.remove(numToRelease);
        return true;
    }
    return false;
}