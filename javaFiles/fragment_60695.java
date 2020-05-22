import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {

    @Parameters
    public static Iterable<Object[]> data() {
        // extract to some class for readability and reuse
        return Arrays.asList(new Object[][] { 
                { new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB) }, 
                { new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB) } 
        });
    }

    private Image image;

    public ParameterTest(Image aImage) {
        image = aImage;
    }

    @Test
    public void testTracerErrorPerPixel() {
        // Do some tests on those images
        System.out.println(image);
    }

    @Test
    public void testTracerCorrectPixelPercent() {
        // Do some different tests on those images
        System.out.println(image);
    }
}