import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MyCounters {
    public static void main(String... args) {
        Runtime rt = Runtime.getRuntime();
        long used1 = rt.totalMemory() - rt.freeMemory();
        long start = System.nanoTime();
        int length = 100 * 1000 * 1000;
        PointCount pc = new PointCountImpl(length);
        for (int i = 0; i < length; i++) {
            pc.index(i);
            pc.setX(i);
            pc.setY(-i);
            pc.setCount(1);
        }
        for (int i = 0; i < length; i++) {
            pc.index(i);
            if (pc.getX() != i) throw new AssertionError();
            if (pc.getY() != -i) throw new AssertionError();
            if (pc.getCount() != 1) throw new AssertionError();
        }
        long time = System.nanoTime() - start;
        long used2 = rt.totalMemory() - rt.freeMemory();
        System.out.printf("Creating an array of %,d used %,d bytes of heap and tool %.1f seconds to set and get%n",
                length, (used2 - used1), time / 1e9);
    }
}

interface PointCount {
    // set the index of the element referred to.
    public void index(int index);

    public double getX();

    public void setX(double x);

    public double getY();

    public void setY(double y);

    public int getCount();

    public void setCount(int count);

    public void incrementCount();
}

class PointCountImpl implements PointCount {
    static final int X_OFFSET = 0;
    static final int Y_OFFSET = X_OFFSET + 8;
    static final int COUNT_OFFSET = Y_OFFSET + 8;
    static final int LENGTH = COUNT_OFFSET + 4;

    final ByteBuffer buffer;
    int start = 0;

    PointCountImpl(int count) {
        this(ByteBuffer.allocateDirect(count * LENGTH).order(ByteOrder.nativeOrder()));
    }

    PointCountImpl(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void index(int index) {
        start = index * LENGTH;
    }

    @Override
    public double getX() {
        return buffer.getDouble(start + X_OFFSET);
    }

    @Override
    public void setX(double x) {
        buffer.putDouble(start + X_OFFSET, x);
    }

    @Override
    public double getY() {
        return buffer.getDouble(start + Y_OFFSET);
    }

    @Override
    public void setY(double y) {
        buffer.putDouble(start + Y_OFFSET, y);
    }

    @Override
    public int getCount() {
        return buffer.getInt(start + COUNT_OFFSET);
    }

    @Override
    public void setCount(int count) {
        buffer.putInt(start + COUNT_OFFSET, count);
    }

    @Override
    public void incrementCount() {
        setCount(getCount() + 1);
    }
}