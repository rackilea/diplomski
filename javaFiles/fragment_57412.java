import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import ortega.HuffmanDecode;

public class Extract {
    private static byte[] deZigZag = {
            0, 1, 5, 6, 14, 15, 27, 28, 2, 4, 7, 13, 16, 26, 29, 42, 3, 8, 12, 17, 25, 30, 41, 43, 9, 11, 18, 24, 31,
            40, 44, 53, 10, 19, 23, 32, 39, 45, 52, 54, 20, 22, 33, 38, 46, 51, 55, 60, 21, 34, 37, 47, 50, 56, 59, 61,
            35, 36, 48, 49, 57, 58, 62, 63 };

    private static int[] extract(InputStream fis, int flength) throws IOException {
        byte[] carrier = new byte[flength];
        fis.read(carrier);
        HuffmanDecode hd = new HuffmanDecode(carrier);
        int[] coeff = hd.decode();
        return coeff;
    }

    public static void main(String[] args) {
        // run with argument the stego jpeg filename
        try {
            File f = new File(args[0]);
            FileInputStream fis = new FileInputStream(f);
            int[] coeff = extract(fis, (int) f.length());

            int idx = deZigZag[23];
            // The coeff array has all of the DCT coefficients in one big
            // array, so that the first 64 elements are the coefficients 
            // from the first block, the next 64 from the second and so on.
            //
            // idx is the position of the embedding DCT coefficient.
            // You can start with that and extract its lsb, then increment
            // by 64 to extract the next bit from the next "block" and so on.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}