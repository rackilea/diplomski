/** Circular buffer */
private class WindowBuffer {
    private final float [] values;
    private final int capacity;
    private float sum;
    private float average;
    private int head = -1;
    private boolean full = false;

    WindowBuffer(final int capacity) {
        this.capacity = capacity;
        values = new float[capacity];
        for (int i = 0; i < capacity; i++) {
            values[i] = 0f;
        }
    }
    void clean() {
        if (head == -1) return;
        for (int i = 0; i < capacity; i++) {
            values[i] = 0f;
        }               
        sum = 0;
        average = 0;
        head = -1;
        full = false;
    }

    void put(final float value) {
        head++;
        if (head >= capacity) {
            head = 0;
            full = true;
        }
        sum -= values[head];
        sum += value;
        values[head] = value;
        calculateAverage();
    }

    private void calculateAverage() {
        if (full) {
            average = sum / capacity;
        } else {
            average = sum / (head + 1);
        }
    }

    float getAverage() {
        return average;
    }
}