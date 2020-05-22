package com.franckyi.lan.installer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javafx.concurrent.Task;

public class UnZipTask extends Task<Void>{

    private File zipfile;
    private File folder;

    public UnZipTask(File zipfile, File folder){
        this.zipfile = zipfile;
        this.folder = folder;
    }

    @Override
    protected Void call() throws Exception {
        FileInputStream is = new FileInputStream(zipfile.getCanonicalFile());
        FileChannel channel = is.getChannel();
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
        ZipEntry ze = null;
        try {
            while ((ze = zis.getNextEntry()) != null) {
                 File f = new File(folder.getCanonicalPath(), ze.getName());
                if (ze.isDirectory()) {
                    f.mkdirs();
                    continue;
                }
                f.getParentFile().mkdirs();
                OutputStream fos = new BufferedOutputStream(new FileOutputStream(f));
                try {
                    try {
                        final byte[] buf = new byte[1024];
                        int bytesRead;
                        long nread = 0L;
                        long length = zipfile.length();

                        while (-1 != (bytesRead = zis.read(buf))){
                            fos.write(buf, 0, bytesRead);
                            nread += bytesRead;
                            System.out.println(nread + "/" + length);
                            updateProgress(channel.position(), length);
                        }
                    } finally {
                        fos.close();
                    }
                } catch (final IOException ioe) {
                    f.delete();
                    throw ioe;
                }
            }
        } finally {
            zis.close();
        }
        return null;
    }

    @Override
    protected void succeeded(){
        System.out.println("Unzip succeeded");
    }

}