package stackoverflow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class Misc {
    public static void main(String argv[]) throws IOException {
        String imageFile1 = "resource/4.jpg";
        String imageFile2 = "resource/4_jpg.jpg";
        String imageFile3 = "resource/4_org.jpg";

        fileCopy(imageFile1, imageFile3);
        //copyImage(imageFile1);

        ImageProperties origin = getJpegProperties(new File(imageFile1));
        ImageProperties copyed = getJpegProperties(new File(imageFile2));

        System.out.println("============ Original one ===========");
        System.out.println("comments(origin) : " + origin.getComments());
        System.out.println("Height(origin) : " + origin.getHeight());
        System.out.println("Width(origin) : " + origin.getWidth());
        System.out.println("Header Length(origin) : " + origin.getHeaderLen());
        //System.out.println("suffix(origin) : " + origin.getSuffix());
        System.out.println();
        System.out.println("============ Copy one ===========");
        System.out.println("comments(copy) : " + copyed.getComments());
        System.out.println("Height(copy) : " + copyed.getHeight());
        System.out.println("Width(copy) : " + copyed.getWidth());
        System.out.println("Header Length(copy) : " + copyed.getHeaderLen());
        //System.out.println("suffix(copy) : " + copyed.getSuffix());

    }

    static class ImageProperties {
        private final int width;
        private final int height;
        private final String comments;
        private final int headerLen;
        private final String suffix;

        public ImageProperties(
            final int width, final int height, final String comments, final int headerLen,
            final String suffix) 
        {
            this.width = width;
            this.height = height;
            this.comments = comments;
            this.suffix = suffix;
            this.headerLen = headerLen;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public String getComments() {
            return comments;
        }

        public String getSuffix() {
            return suffix;
        }

        public int getHeaderLen() {
            return headerLen;
        }

    }

    final public static ImageProperties getJpegProperties(File file) throws FileNotFoundException, IOException {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));

            // check for "magic" header
            byte[] buf = new byte[2];
            int count = in.read(buf, 0, 2);
            if (count < 2) {
                throw new RuntimeException("Not a valid Jpeg file!");
            }
            if ((buf[0]) != (byte) 0xFF || (buf[1]) != (byte) 0xD8) {
                throw new RuntimeException("Not a valid Jpeg file!");
            }

            int width = 0;
            int height = 0;
            char[] comment = null;

            boolean hasDims = false;
            boolean hasComment = false;
            int ch = 0;
            int totalHeaderLen = 0;

            while (ch != 0xDA && !(hasDims && hasComment)) {
                /* Find next marker (JPEG markers begin with 0xFF) */
                while (ch != 0xFF) {
                    ch = in.read();
                }
                /* JPEG markers can be padded with unlimited 0xFF's */
                while (ch == 0xFF) {
                    ch = in.read();
                }
                /* Now, ch contains the value of the marker. */

                int length = 256 * in.read();
                length += in.read();

                totalHeaderLen += length;

                if (length < 2) {
                    throw new RuntimeException("Not a valid Jpeg file!");
                }
                /* Now, length contains the length of the marker. */

                if (ch >= 0xC0 && ch <= 0xC3) {
                    in.read();
                    height = 256 * in.read();
                    height += in.read();
                    width = 256 * in.read();
                    width += in.read();
                    for (int foo = 0; foo < length - 2 - 5; foo++) {
                        in.read();
                    }
                    hasDims = true;
                } else if (ch == 0xFE) {
                    // that's the comment marker
                    comment = new char[length - 2];
                    for (int foo = 0; foo < length - 2; foo++)
                        comment[foo] = (char) in.read();
                    hasComment = true;
                } else {
                    // just skip marker
                    for (int foo = 0; foo < length - 2; foo++) {
                        in.read();
                    }
                }
            }

            if(comment == null) comment = "no comment".toCharArray();

            return (new ImageProperties(width, height, new String(comment), totalHeaderLen, "jpeg"));

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static BufferedImage copyImage(BufferedImage source) {
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }


    private static void fileCopy(String from, String to) {
        FileChannel fromCh = null;
        FileChannel toCh = null;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(new File(from));
            fromCh = fin.getChannel();
            fout = new FileOutputStream(new File(to));
            toCh = fout.getChannel();

            fromCh.transferTo(0, fin.available(), toCh);

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (fin != null)
                try {
                    fin.close();
                } catch (IOException e) {

                }
            if (fout != null)
                try {
                    fout.close();
                } catch (IOException e) {

                }

        }
    }

}