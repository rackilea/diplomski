import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

String base64String = "...";
byte[] bytes = DatatypeConverter.parseBase64Binary(base64String);
ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
BufferedImage img = ImageIO.read(bin);
// NB ImageIO doesn't close the provided input stream, but ByteArrayInputStream
// doesn't need to be closed anyway so it doesn't matter.