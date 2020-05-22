import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.MappedByteBuffer;

class Testbb2 {
    /** Buffer a whole lot of long values at the same time. */
    static final int BUFFSIZE = 0x800 * 8; // 8192
    static final int DATASIZE = 0x8000 * BUFFSIZE;

    static public long byteArrayToLong(byte [] in, int offset) {
        return ((((((((long)(in[offset + 0] & 0xff) << 8) | (long)(in[offset + 1] & 0xff)) << 8 | (long)(in[offset + 2] & 0xff)) << 8 | (long)(in[offset + 3] & 0xff)) << 8 | (long)(in[offset + 4] & 0xff)) << 8 | (long)(in[offset + 5] & 0xff)) << 8 | (long)(in[offset + 6] & 0xff)) << 8 | (long)(in[offset + 7] & 0xff);
    }

    public static void main(String [] args) throws IOException {
        long start;
        RandomAccessFile fileHandle;
        FileChannel fileChannel;

        // Sanity check - this way the convert-to-long loops don't need extra bookkeeping like BUFFSIZE / 8.
        if ((DATASIZE % BUFFSIZE) > 0 || (DATASIZE % 8) > 0) {
            throw new IllegalStateException("DATASIZE should be a multiple of 8 and BUFFSIZE!");
        }

        int pos;
        int nDone;

        // create file
        File testFile = new File("file.dat");
        fileHandle = new RandomAccessFile("file.dat", "rw");

        if (testFile.exists() && testFile.length() >= DATASIZE) {
            System.out.println("File exists");
        } else {
            testFile.delete();
            System.out.println("Preparing file");
            byte [] buffer = new byte[BUFFSIZE];
            pos = 0;
            nDone = 0;
            while (pos < DATASIZE) {
                fileHandle.write(buffer);
                pos += buffer.length;
            }

            System.out.println("File prepared");
        } 
        fileChannel = fileHandle.getChannel();

        // mmap()
        MappedByteBuffer mbb = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, DATASIZE);
        byte [] buffer1 = new byte[BUFFSIZE];
        mbb.position(0);
        start = System.currentTimeMillis();
        pos = 0;
        while (pos < DATASIZE) {
            mbb.get(buffer1, 0, BUFFSIZE);
            // This assumes BUFFSIZE is a multiple of 8.
            for (int i = 0; i < BUFFSIZE; i += 8) {
                long dummy = byteArrayToLong(buffer1, i);
            }
            pos += BUFFSIZE;
        }
        System.out.println("mmap: " + (System.currentTimeMillis() - start) / 1000.0);

        // bytebuffer
        ByteBuffer buffer2 = ByteBuffer.allocateDirect(BUFFSIZE);
//        buffer2.order(ByteOrder.nativeOrder());
        buffer2.order();
        fileChannel.position(0);
        start = System.currentTimeMillis();
        pos = 0;
        nDone = 0;
        while (pos < DATASIZE) {
            buffer2.rewind();
            fileChannel.read(buffer2);
            buffer2.rewind();   // need to rewind it to be able to use it
            // This assumes BUFFSIZE is a multiple of 8.
            for (int i = 0; i < BUFFSIZE; i += 8) {
                long dummy = buffer2.getLong();
            }
            pos += BUFFSIZE;
        }
        System.out.println("bytebuffer: " + (System.currentTimeMillis() - start) / 1000.0);

        // regular i/o
        fileHandle.seek(0);
        byte [] buffer3 = new byte[BUFFSIZE];
        start = System.currentTimeMillis();
        pos = 0;
        while (pos < DATASIZE && nDone != -1) {
            nDone = 0;
            while (nDone != -1  && nDone < BUFFSIZE) {
                nDone = fileHandle.read(buffer3, nDone, BUFFSIZE - nDone);
            }
            // This assumes BUFFSIZE is a multiple of 8.
            for (int i = 0; i < BUFFSIZE; i += 8) {
                long dummy = byteArrayToLong(buffer3, i);
            }
            pos += nDone;
        }
        System.out.println("regular i/o: " + (System.currentTimeMillis() - start) / 1000.0);
    }
}