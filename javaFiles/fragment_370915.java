import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/**
 * The Class TarArchive.
 */
public class TarArchive {

    /**
     * Creates the tar of files.
     *
     * @param files the files
     * @param tarPath the tar path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void createTarOfFiles(String[] files, String tarPath) throws IOException
    {
        FileOutputStream fOut = null;
        BufferedOutputStream bOut = null;
        TarArchiveOutputStream tOut = null;

        Arrays.sort(files);
        try
        {
            fOut = new FileOutputStream(new File(tarPath));
            bOut = new BufferedOutputStream(fOut);
            tOut = new TarArchiveOutputStream(bOut);

            for (String file : files) {
                addFileToTar(tOut, file, "");
            }
        }
        finally
        {
            tOut.finish();
            tOut.close();
            bOut.close();
            fOut.close();
        }
    }

    /**
     * Creates the tar of directory.
     *
     * @param directoryPath the directory path
     * @param tarPath the tar path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void createTarOfDirectory(String directoryPath, String tarPath) throws IOException
    {
        FileOutputStream fOut = null;
        BufferedOutputStream bOut = null;
        TarArchiveOutputStream tOut = null;

        try
        {
            fOut = new FileOutputStream(new File(tarPath));
            bOut = new BufferedOutputStream(fOut);
            tOut = new TarArchiveOutputStream(bOut);

            addFileToTar(tOut, directoryPath, "");
        }
        finally
        {
            tOut.finish();
            tOut.close();
            bOut.close();
            fOut.close();
        }
    }

    /**
     * Adds the file to tar.
     *
     * @param tOut the t out
     * @param path the path
     * @param base the base
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void addFileToTar(TarArchiveOutputStream tOut, String path, String base) throws IOException
    {
        File f = new File(path);
        String entryName = base + f.getName();
        TarArchiveEntry tarEntry = new TarArchiveEntry(f, entryName);

        tOut.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);

        if(f.isFile())
        {
           tarEntry.setModTime(0);
           tOut.putArchiveEntry(tarEntry);

           IOUtils.copy(new FileInputStream(f), tOut);

           tOut.closeArchiveEntry();
        }
        else
        {
            File[] children = f.listFiles();
            Arrays.sort(children);

            if(children != null)
            {
                for(File child : children)
                {
                    addFileToTar(tOut, child.getAbsolutePath(), entryName + "/");
                }
            }
        }
    }
}