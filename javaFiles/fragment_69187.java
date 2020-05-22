import java.awt.color.ColorSpace
import java.awt.color.ICC_Profile
import java.awt.image.BufferedImage
import java.nio.file.Path
import javax.imageio.ImageIO

object ImgLoadUtils {
    init {
        // Load deferred color space profiles to avoid 
        // ConcurrentModificationException due to JDK
        // Use in public static main void or prior to application initialization
        // https://github.com/haraldk/TwelveMonkeys/issues/402
        // https://bugs.openjdk.java.net/browse/JDK-6986863
        // https://stackoverflow.com/questions/26297491/imageio-thread-safety
        ICC_Profile.getInstance(ColorSpace.CS_sRGB).getData();
        ICC_Profile.getInstance(ColorSpace.CS_PYCC).getData();
        ICC_Profile.getInstance(ColorSpace.CS_GRAY).getData();
        ICC_Profile.getInstance(ColorSpace.CS_CIEXYZ).getData();
        ICC_Profile.getInstance(ColorSpace.CS_LINEAR_RGB).getData();
    }

    fun loadImage(p: Path): BufferedImage = ImageIO.read(p.toFile())
}