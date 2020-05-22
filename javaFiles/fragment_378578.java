import java.io.*;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.Enumeration;

public class Unzipper {
    public static void main(String[] args)
            throws IOException {
        final File file = new File(args[0]);
        final ZipFile zipFile = new ZipFile(file);
        final byte[] buffer = new byte[2048];
        final File tmpDir = new File(System.getProperty("java.io.tmpdir"), zipFile.getName());

        if(!tmpDir.mkdir() && tmpDir.exists()) {
            System.err.println("Cannot create: " + tmpDir);
            System.exit(0);
        }

        for(final Enumeration entries = zipFile.entries(); entries.hasMoreElements();) {
            final ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            System.out.println("Unzipping: " + zipEntry.getName());

            final InputStream is = zipFile.getInputStream(zipEntry);
            final File fileToWrite = new File(tmpDir, zipEntry.getName());
            final File folder = fileToWrite.getParentFile();
            if(!folder.mkdirs() && !folder.exists()) {
                System.err.println("Cannot create: " + folder);
                System.exit(0);
            }

            if(!zipEntry.isDirectory()) {
                //No need to use buffered streams since we're doing our own buffering
                final FileOutputStream fos = new FileOutputStream(fileToWrite);
                int size;
                while ((size = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, size);
                }
                fos.close();
                is.close();
            }
        }
        zipFile.close();
    }
}