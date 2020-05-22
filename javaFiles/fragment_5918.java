public abstract class Foo implements Closeable {
    public final void close() {
        // do whatever
        doClose();
    }

    protected abstract void doClose();
}

public abstract class Bar {
    public void read(byte[] b) {
        for(int x = 0; x < b.length; x++) {
            b[x] = read();
        }
    }

    public abstract int read();
}