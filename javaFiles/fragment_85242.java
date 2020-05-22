import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Bin {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new  FileOutputStream("\\test.bin");
        String digits="12345";
        char[] chars = digits.toCharArray();
        for ( int i = 0 ; i < chars.length ; i+= 2 ) {
            byte b1 = (byte) (chars[i] - (byte) '0');
            byte b2 = (byte) (i < chars.length-1 ? chars[i+1] - (byte) '0' : 0xf);
            fos.write((byte) ((b1 << 4) | b2 ));
        }
        fos.close();
        FileInputStream fis = new FileInputStream("\\test.bin");
        StringBuffer result = new StringBuffer();
        byte[] buf = new byte[100];
        int read = fis.read(buf);
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        for ( int i = 0 ; i < read ; i++ ) {
            byte both = (byte) bais.read();
            byte b1 = (byte) ((both >> 4 ) & 0xf);
            byte b2 = (byte) (both  & 0xf) ;
            result.append( Character.forDigit(b1, 10));
            if ( b2 != 0xf ) {
                result.append(Character.forDigit(b2,10));
            }
        }
        System.out.println(result.toString());
    }
}