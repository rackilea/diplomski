import java.io.File;
import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;
import java.util.Arrays;

class LongIntParallelHashMultimap {
    public static final int BUFFER_BITS = 24;
    private final FileChannel fc;
    private final ByteBuffer[] keys, data;
    private final int topBits, topMask, offsetMask;

    public LongIntParallelHashMultimap(String fileName, int sizeBits, boolean load) throws IOException {
        fc = new RandomAccessFile(fileName, "rw").getChannel();
        long totalSize = 4L << sizeBits;
        int bufferIndex = (int) (totalSize >> BUFFER_BITS);
        keys = new ByteBuffer[bufferIndex];
        data = new ByteBuffer[bufferIndex];
        int bufferSize = 1 << BUFFER_BITS;
        long offset = 0;
        for (int i = 0; i < bufferIndex; i++) {
            MappedByteBuffer kmap = fc.map(FileChannel.MapMode.READ_WRITE, offset, bufferSize);
            kmap.load();
            keys[i] = kmap.order(ByteOrder.nativeOrder());
            MappedByteBuffer dmap = fc.map(FileChannel.MapMode.READ_WRITE, offset + bufferSize, bufferSize);
            dmap.load();
            data[i] = dmap.order(ByteOrder.nativeOrder());
            offset += bufferSize * 2;
        }
        topBits = sizeBits + 2 - BUFFER_BITS;
        topMask = (1 << topBits) - 1;
        offsetMask = bufferSize - 4;
    }

    public void put(int key, int value) {
        int buffer = key & topMask;
        int key2 = (key >> topBits) + 1;
        assert key2 != 0;
        ByteBuffer keys2 = keys[buffer];
        ByteBuffer data2 = data[buffer];
        int offset = (key2 * 101) & offsetMask;
        while (keys2.getInt(offset) != 0) {
            offset += 3 * 4;
            offset &= offsetMask;
        }
        keys2.putInt(offset, key2);
        data2.putInt(offset, value);
    }

    public int get(int key, int[] values) {
        int buffer = key & topMask;
        int key2 = (key >> topBits) + 1;
        assert key2 != 0;
        ByteBuffer keys2 = keys[buffer];
        ByteBuffer data2 = data[buffer];
        int offset = (key2 * 101) & offsetMask;
        for (int count = 0; count < values.length; ) {
            int key3 = keys2.getInt(offset);
            if (key3 == 0)
                return count;
            if (key3 == key2)
                values[count++] = data2.getInt(offset);

            offset += 3 * 4;
            offset &= offsetMask;
        }
        return values.length;
    }

    private final int[] getValues = new int[1000];
    private static final int[] NO_VALUES = { };

    public int[] get(int key) {
        int len = get(key, getValues);
        return len == 0 ? NO_VALUES : Arrays.copyOf(getValues, len);
    }

    public static void main(String... args) throws IOException {
        int keys = 500 * 1000 * 1000;

        new File("abc.bin").delete();
        long startTime = System.nanoTime();
        LongIntParallelHashMultimap lph = new LongIntParallelHashMultimap("abc.bin", 30, true);
        long time = System.nanoTime() - startTime;
        System.out.printf("Load time was %.3f sec%n", time / 1e9);

        timePut(keys, lph);

        timeGet(keys, lph);

        timeGet2(keys, lph);

        startTime = System.nanoTime();
        System.gc();
        time = System.nanoTime() - startTime;
        System.out.printf("Time to Full GC was %.3f sec%n", time / 1e9);
    }

    private static void timePut(int keys, LongIntParallelHashMultimap lph) {
        long startTime;
        long time;
        startTime = System.nanoTime();
        for (int i = 0; i < keys; i++) {
            lph.put(i, i + 100);
            if ((i + 1) % 100_000_000 == 0)
                System.out.printf("%,d ", i + 1);
        }
        time = System.nanoTime() - startTime;
        System.out.printf("%nput time was %.3f sec%n", time / 1e9);
    }

    private static void timeGet(int keys, LongIntParallelHashMultimap lph) {
        long startTime;
        long time;
        startTime = System.nanoTime();
        int[] values = new int[2];
        for (int i = 0; i < keys; i++) {
            lph.get(i, values);
            if ((i + 1) % 100_000_000 == 0)
                System.out.printf("%,d ", i + 1);
        }
        time = System.nanoTime() - startTime;
        System.out.printf("%nget(key, values) time was %.3f sec%n", time / 1e9);
    }

    private static void timeGet2(int keys, LongIntParallelHashMultimap lph) {
        long startTime;
        long time;
        startTime = System.nanoTime();
        for (int i = 0; i < keys; i++) {
            lph.get(i);
            if ((i + 1) % 100_000_000 == 0)
                System.out.printf("%,d ", i + 1);
        }
        time = System.nanoTime() - startTime;
        System.out.printf("%nget(key) time was %.3f sec%n", time / 1e9);
    }
}