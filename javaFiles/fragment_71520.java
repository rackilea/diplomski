public class ScanForByteCombo {

    public static List<Long> scanFor(InputStream is, int needle) throws IOException {
        List<Long> foundOffsets = new ArrayList<>();
        InputStream bs = new BufferedInputStream(is, 0x10000);
        int data = 0;
        int b;
        long offset = 0;
        while ((b = bs.read()) != -1) {
            data = (data << 8) | b;
            if (data == needle) 
                foundOffsets.add(offset);
            ++offset;
        }
        return foundOffsets;
    }

    public static void main(String[] argv) {

        int needle = ('A' << 24) | ('X' << 16) | ('F' << 8) | '0';

        long start = System.currentTimeMillis();
        try (InputStream is = new FileInputStream("your file")) {
            List<Long> found = scanFor(is, needle);
            System.out.println(found);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("scan took " + (System.currentTimeMillis() - start) + "ms. Acceptable?");
    }

}