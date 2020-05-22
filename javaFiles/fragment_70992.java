import java.io.*;

public class FileCopyProgress {
    public static void main(String[] args) {
        System.out.println("copying file");
        File filein  = new File("test.big");
        File fileout = new File("test_out.big");
        FileInputStream  fin  = null;
        FileOutputStream fout = null;
        long length  = filein.length();
        long counter = 0;
        int r = 0;
        byte[] b = new byte[1024];
        try {
                fin  = new FileInputStream(filein);
                fout = new FileOutputStream(fileout);
                while( (r = fin.read(b)) != -1) {
                        counter += r;
                        System.out.println( 1.0 * counter / length );
                        fout.write(b, 0, r);
                }
        }
        catch(Exception e){
                System.out.println("foo");
        }
    }
}