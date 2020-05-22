public class AtomicBooleanArray {
    private final AtomicInteger intFlags = new AtomicInteger();

    public void get(boolean[] arr) {
        int flags = intFlags.get();

        int f = 1;
        for(int i = 0; i < 32; i++) {
            arr[i] = (flags & f) != 0;
            f <<= 1;
        }
    }

    public void set(boolean[] arr) {
        int flags = 0;

        int f = 1;
        for(int i = 0; i < 32; i++) {
            if(arr[i]) {
                flags |= f;
            }
            f <<= 1;
        }

        intFlags.set(flags);
    }

    public boolean get(int index) {
        return (intFlags.get() & (1 << index)) != 0;
    }

    public void set(int index, boolean b) {
        int f = 1 << index;

        int current, updated;
        do {
            current = intFlags.get();
            updated = b ? (current | f) : (current & ~f);
        } while(!intFlags.compareAndSet(current, updated));
    }
}