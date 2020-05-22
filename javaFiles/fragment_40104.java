import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class SaveImage {

    public static void main(String[] args) throws IOException {

        byte[] imageBytes;
        try (RandomAccessFile binaryReader =
                     new RandomAccessFile("your-file.xxx", "r")) {

            int dataLength = 0; // Assign this the byte length shown in your
                                // post instead of zero

            int startPos = 0;   // I assume you can find this somehow.
                                // If it's not at the beginning
                                // change it accordingly.

            imageBytes = new byte[dataLength];
            binaryReader.read(imageBytes, startPos, dataLength);
        }

        try (InputStream in = new ByteArrayInputStream(imageBytes)) {
            BufferedImage bImageFromConvert = ImageIO.read(in);
            ImageIO.write(bImageFromConvert,
                    "jpg",  // or whatever file format is appropriate
                    new File("/path/to/your/file.jpg"));
        }
    }
}