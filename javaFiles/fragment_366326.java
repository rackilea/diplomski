package com.intellectdesign.cash.gdm.common;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageByte {


    public static void main(String args[]) throws MalformedURLException, IOException {

        getImageAndTypeFromInputStream();

    }

    public static byte[] getImageAndTypeFromInputStream() throws MalformedURLException, IOException {

        String format = null;
        BufferedImage bufferedimage = null;
        InputStream input = null;

        URLConnection openConnection = new URL("http://www.thumbprintbooks.ca/wp-content/uploads/Vignettes-Photos-Spine-Inset-In-Plinth-thumbnail-c-Thumbprint-Books.jpg").openConnection();
        openConnection.addRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");

        input = openConnection.getInputStream();
        System.out.println("input : " + input.toString());
        System.out.println("input : " + input.getClass());
        System.out.println("input : " + input.available());

        BufferedInputStream in=new BufferedInputStream(input);

        ImageInputStream stream=ImageIO.createImageInputStream(in);

        Iterator readers=ImageIO.getImageReaders(stream);

        if (readers.hasNext()) {

            System.out.println("if block");
            ImageReader reader = (ImageReader) readers.next();
            format = reader.getFormatName();
            reader.setInput(stream);
            bufferedimage = reader.read(0);

            new BufferedImageWrapper(format, bufferedimage);

            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedimage, "jpg", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else {
            System.out.println("else block");
            String text = "OOPS !!!";
            byte convertEntry[] = text.getBytes();
            return convertEntry;
        }

    }

    public static class BufferedImageWrapper {

        private final String imageType;
        private final BufferedImage bufferedimage;

        public BufferedImageWrapper(String imageType, BufferedImage bufferedimage) {
            System.out.println("in Buffered image Wrapper");
            this.imageType = imageType;
            this.bufferedimage = bufferedimage;
        }

        public String getImageType() {

            return imageType;
        }

        public BufferedImage getBufferedimage() {

            return bufferedimage;
        }

    }
}