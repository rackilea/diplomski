import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.util.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;

class LongIntParallelHashMultimap {
    private static final int[] NO_INTS = {};

    final int[][] data;

    public LongIntParallelHashMultimap() {
        data = new int[Integer.MAX_VALUE][];
    }

    public void put(int key, int value) {
        int[] ints = data[key];
        if (ints == null) {
            data[key] = new int[]{value};
        } else {
            int[] ints2 = Arrays.copyOf(ints, ints.length + 1);
            ints2[ints.length] = value;
            data[key] = ints2;
        }
    }

    public int[] get(int key) {
        int[] ints = data[key];
        return ints == null ? NO_INTS : ints;
    }

    private FileChannel channel;
    private MappedByteBuffer mbb;

    public void save() throws IOException {
        channel = new RandomAccessFile("abc.bin", "rw").getChannel();
        mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1 << 24);
        mbb.order(ByteOrder.nativeOrder());

        for (int i = 0; i < Integer.MAX_VALUE - 32; i += 32) {
            int bits = 0;
            for (int j = 0; j < 32; j++) {
                if (data[i + j] != null) bits |= 1;
                bits <<= 1;
            }
            getMbb().putInt(bits);
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int arr[] = get(i);
            if (arr.length == 0) continue;
            getMbb().putInt(arr.length);
            for (int a : arr)
                getMbb().putInt(a);
        }
        channel.close();
        cleanMbb();
    }

    private ByteBuffer getMbb() throws IOException {
        if (mbb.remaining() <= 0) {
            cleanMbb();
            mbb = channel.map(FileChannel.MapMode.READ_WRITE, channel.size(), 1 << 24);
            mbb.order(ByteOrder.nativeOrder());
        }
        return mbb;
    }

    private void cleanMbb() {
        ((DirectBuffer) mbb).cleaner().clean();
    }


    public static void main(String... args) throws IOException {
        int keys = 50 * 1000 * 1000;

        long startTime = System.nanoTime();
        LongIntParallelHashMultimap lph = new LongIntParallelHashMultimap();
        long time = System.nanoTime() - startTime;
        System.out.printf("Create time %.3f sec%n", time / 1e9);

        startTime = System.nanoTime();
        for (int i = 0; i < keys; i++) {
            lph.put(i, i + 100);
            if (i % 10000000 == 0 && i != 0)
                System.out.print(" " + i + " ");
        }
        time = System.nanoTime() - startTime;
        System.out.printf("%nput time was %.3f sec%n", time / 1e9);

        startTime = System.nanoTime();
        lph.save();
        time = System.nanoTime() - startTime;
        System.out.printf(" time to save was %.3f sec%n", time / 1e9);

        startTime = System.nanoTime();
        for (int i = 0; i < keys; i++) {
            int k[] = lph.get(i);
        }
        time = System.nanoTime() - startTime;
        System.out.printf("get time was %.3f sec%n", time / 1e9);
    }
}