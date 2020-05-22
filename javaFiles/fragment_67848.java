/**
 * Accumulator object to hold the current min
 * and the list of Foos that are the min.
 */
class Accumulator {
    Integer min;
    List<Foo> foos;

    Accumulator() {
        min = Integer.MAX_VALUE;
        foos = new ArrayList<>();
    }

    void accumulate(Foo f) {
        if (f.getVariableCount() != null) {
            if (f.getVariableCount() < min) {
                min = f.getVariableCount();
                foos.clear();
                foos.add(f);
            } else if (f.getVariableCount() == min) {
                foos.add(f);
            }
        }
    }

    Accumulator combine(Accumulator other) {
        if (min < other.min) {
            return this;
        }
        else if (min > other.min) {
            return other;
        }
        else {
            foos.addAll(other.foos);
            return this;
        }
    }

    List<Foo> getFoos() { return foos; }
}