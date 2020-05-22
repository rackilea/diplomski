public class Test {
    public static void main(String[] args) throws Exception {
        try (RandomAccessFile raf = new RandomAccessFile("test", "rw")) {
            raf.writeChars("\u0020");
        }
    }
}