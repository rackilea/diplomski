import javax.imageio.stream.*
import javax.imageio.*

BufferedImage bufferedImage = ImageIO.read(new File("test.png"));
float quality = 0.9;
ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionQuality(quality);
writer.setOutput(new FileImageOutputStream(new File("test.jpg")));
writer.write(null, new IIOImage(bufferedImage, null, null), param);