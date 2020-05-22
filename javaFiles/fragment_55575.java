import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Essai2 {

    public static void main(String[] args) {

        try {

            byte[] imageInByte;
            BufferedImage originalImage1 = ImageIO.read(new File("essai1.jpg"));
            BufferedImage originalImage2 = ImageIO.read(new File("essai2.jpg"));

            // convert BufferedImage to byte array
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            ImageIO.write(originalImage1, "jpg", baos1);
            ImageIO.write(originalImage2, "jpg", baos2);
            baos1.flush();
            baos2.flush();
            byte[] ba1 = baos1.toByteArray();
            byte[] ba2 = baos2.toByteArray();
            imageInByte = new byte[ba1.length + ba2.length];
            //System.out.println(new String(imageInByte));
            System.arraycopy(ba1, 0, imageInByte, 0, ba1.length);
            //System.out.println(new String(imageInByte));
            System.arraycopy(ba2, 0, imageInByte, ba1.length, ba2.length);
            //System.out.println(new String(imageInByte));
            baos1.close();
            baos2.close();

            // convert byte array back to BufferedImage
            InputStream in = new ByteArrayInputStream(imageInByte);

            int w = Math.max(originalImage1.getWidth(), originalImage2.getWidth());
            //int h = Math.max(originalImage1.getHeight(), originalImage2.getHeight());
            int h = originalImage1.getHeight() + originalImage2.getHeight();
            BufferedImage bImageFromConvert = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            //BufferedImage bImageFromConvert = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR );

            //BufferedImage bImageFromConvert = ImageIO.read(in);

            Graphics g = bImageFromConvert.getGraphics();
            g.drawImage(originalImage1, 0, 0, null);
            g.drawImage(originalImage2, 0, originalImage1.getHeight(), null);

            ImageIO.write(bImageFromConvert, "jpg", new File("result.jpg"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}