package org.snb;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class PdfTester {
    public static void main(String[] args) {
        //get the url page from the arguments array

        try{
            //String arg = args[0];
            URL url = new URL("http://www.pdf995.com/samples/pdf.pdf");
            //jpg
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[131072];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
               out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream("/tmp/bart.pdf");
            fos.write(response);
            fos.close();
         }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}