import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class ReadWriteImage {

    public static void main(String[] args) {
        try {
            writeTest();
            readTest();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readTest() throws IOException {
        String filepath = "myfile.txt";
        BufferedImage image = null;
        try (InputStream is = new FileInputStream(new File(filepath))) {

            int lineCount = 0;
            StringBuilder sb = new StringBuilder(128);

            String number = null;
            String title = null;
            String text = null;

            int b = -1;
            while (lineCount < 3 && (b = is.read()) != -1) {
                if ((char)b == '\n') {
                    switch (lineCount) {
                        case 0:
                            number = sb.toString();
                            break;
                        case 1:
                            title = sb.toString();
                            break;
                        case 2:
                            text = sb.toString();
                            break;
                    }
                    sb.delete(0, sb.length());
                    lineCount++;
                } else {
                    sb.append((char)b);
                }
            }

            System.out.println(number);
            System.out.println(title);
            System.out.println(text);

            ImageInputStream iis = ImageIO.createImageInputStream(is);
            image = ImageIO.read(iis);
            ImageIO.write(image, "png", new File("test.png"));
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static void writeTest() throws IOException {
        String filepath = "myfile.txt";
        BufferedImage image = ImageIO.read(new File("/Users/swhitehead/Dropbox/MegaTokyo/thumnails/2005-09-29-3957_400.jpg"));

        try (FileOutputStream output = new FileOutputStream(filepath)) {

            output.write("Number: 176\n".getBytes());
            output.write("Title: Elephant\n".getBytes());
            output.write("Text: This image shows a cute elephant.\n".getBytes());

            ImageIO.write(image, "png", output);

            output.flush();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }
}