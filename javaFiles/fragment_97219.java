import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IdentifyImage {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;

        try {
            in = new FileInputStream("sample.gif");

            //The following are in base 10
            byte[] gifHeader87a = {71, 73, 70, 56, 55, 97};
            byte[] gifHeader89a = {71, 73, 70, 56, 57, 97};

            byte[] bytes = new byte[6];
            in.read(bytes, 0, 6);

            if(Arrays.equals(gifHeader89a, bytes) || Arrays.equals(gifHeader87a, bytes)) {
               System.out.println("It's a GIF!");
            }

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}