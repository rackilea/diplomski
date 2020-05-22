import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;

public class Test {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://cdn.discordapp.com/attachments/235200958974394368/256888406645145602/output.jpg");
        URLConnection openConnection = url.openConnection();
        boolean check = true;

        try {

            openConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            openConnection.connect();

            if (openConnection.getContentLength() > 8000000) {
                System.out.println(" file size is too big.");
                check = false;
            }
        } catch (Exception e) {
            System.out.println("Couldn't create a connection to the link, please recheck the link.");
            check = false;
            e.printStackTrace();
        }
        if (check) {
            BufferedImage img = null;
            try {
                InputStream in = new BufferedInputStream(openConnection.getInputStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }
                out.close();
                in.close();
                byte[] response = out.toByteArray();
                img = ImageIO.read(new ByteArrayInputStream(response));
            } catch (Exception e) {
                System.out.println(" couldn't read an image from this link.");
                e.printStackTrace();
            }
            JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(0.1f);
            File file = new File("output.jpg");
            try {
                final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
                writer.setOutput(new FileImageOutputStream(file));
                writer.write(null, new IIOImage(img, null, null), jpegParams);
                // event.getChannel().sendFile(file, null).queue();
                // file.delete();
            } catch (IOException e) {
                System.out.println("Couldn't create/send the output image.");
                e.printStackTrace();
            }
        }
    }

}