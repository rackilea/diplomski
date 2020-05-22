abstract class Box {

    Set<Integer> balls = new HashSet<>();
    abstract boolean canAdd(int n);

    boolean add(int n) {
        if (!canAdd(n)) return false;
        balls.add(n);
        return true;
    }

    void remove(int n) { balls.remove(n); }
    @Override public String toString() { return balls.toString(); }
}

class Box1 extends Box {
    // has a capacity of 1 (only 1 integer fits into it at one time)
    boolean canAdd(int n) {
        return balls.size() < 1;
    }
}

class Box13 extends Box {
    // cannot contain 2 integers which sum up to 13
    boolean canAdd(int n) {
        int remain = 13 - n;
        return !balls.contains(remain);
    }
}