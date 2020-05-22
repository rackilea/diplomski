import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NewClass9 {

public static void main(String[] args) throws IOException{
  BufferedImage img = null;
  img = ImageIO.read(new File("C:\\users\\uzochi\\desktop\\Penguins.jpg"));
  for(int i = 0;i<10;i++){
    BufferedImage sub = img.getSubimage(0, i*(img.getHeight()/10), img.getWidth(), img.getHeight()/10);
    File f = new File("C:\\users\\uzochi\\desktop\\SubImage"+i+".png");
    ImageIO.write(sub, "png", f);
  }
}