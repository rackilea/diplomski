import java.io.*;
import java.util.zip.*;

class Unzip {
    public static void main(String[] args) throws Exception {
        String Path = ".";
        String FileName = "91.zip";
        File zipFile = new File(Path, FileName);

        FileInputStream fin = new FileInputStream(zipFile);
        ZipInputStream zin = new ZipInputStream(fin);

        ZipEntry ze = null;
        int UnzipCounter = 0;
        while ((ze = zin.getNextEntry()) != null) {
            UnzipCounter++;
            //if (ze.isDirectory()) {
            //  dirChecker(ze.getName());
            //} else {
                byte[] Unzipbuffer = new byte[(int) pow(2, 16)];
                FileOutputStream fout = new FileOutputStream(
                    new File(Path, ze.getName()));
                int Unziplength = 0;
                while ((Unziplength = zin.read(Unzipbuffer)) > 0) {
                    fout.write(Unzipbuffer, 0, Unziplength);
                }
                zin.closeEntry();
                fout.close();
            //}
        }
        zin.close();
    }
}