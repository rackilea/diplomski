import java.io.File;
import java.io.RandomAccessFile;

public class VideoCrypt {
    public static final int REVERSE_BYTE_COUNT = 1024;

    public static boolean decrypt(String path) {
        try {
            if (path == null) return false;
            File source = new File(path);
            int byteToReverse = source.length() < REVERSE_BYTE_COUNT ? ((int) source.length()) : REVERSE_BYTE_COUNT;
            RandomAccessFile f = new RandomAccessFile(source, "rw");
            f.seek(0);
            byte b[] = new byte[byteToReverse];
            f.read(b);
            f.seek(0);
            reverseBytes(b);
            f.write(b);
            f.seek(0);
            b = new byte[byteToReverse];
            f.read(b);
            f.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean encrypt(String path) {
        try {
            if (path == null) return false;
            File source = new File(path);
            RandomAccessFile f = new RandomAccessFile(source, "rw");
            f.seek(0);
            int byteToReverse = source.length() < REVERSE_BYTE_COUNT ? ((int) source.length()) : REVERSE_BYTE_COUNT;
            byte b[] = new byte[byteToReverse];
            f.read(b);
            f.seek(0);
            reverseBytes(b);
            f.write(b);
            f.seek(0);
            b = new byte[byteToReverse];
            f.read(b);
            f.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void reverseBytes(byte[] array) {
        if (array == null) return;
        int i = 0;
        int j = array.length - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
}