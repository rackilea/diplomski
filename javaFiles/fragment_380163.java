import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.IOException;
import java.util.Arrays;


public class ColorConv {
    final static String pathToCMYKProfile = "C:\\UncoatedFOGRA29.icc";

    public static float[] rgbToCmyk(float... rgb) throws IOException {
        if (rgb.length != 3) {
            throw new IllegalArgumentException();
        }
        ColorSpace instance = new ICC_ColorSpace(ICC_Profile.getInstance(pathToCMYKProfile));
        float[] fromRGB = instance.fromRGB(rgb);
        return fromRGB;
    }
    public static float[] cmykToRgb(float... cmyk) throws IOException {
        if (cmyk.length != 4) {
            throw new IllegalArgumentException();
        }
        ColorSpace instance = new ICC_ColorSpace(ICC_Profile.getInstance(pathToCMYKProfile));
        float[] fromRGB = instance.toRGB(cmyk);
        return fromRGB;
    }

    public static void main(String... args) {
        try {
            float[] rgbToCmyk = rgbToCmyk(1.0f, 1.0f, 1.0f);
            System.out.println(Arrays.toString(rgbToCmyk));
            System.out.println(Arrays.toString(cmykToRgb(rgbToCmyk[0], rgbToCmyk[1], rgbToCmyk[2], rgbToCmyk[3])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}