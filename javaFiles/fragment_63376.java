package q34460547;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadTest {

    public static void main(String[] args) throws IOException {
        new LoadTest().loadStdImage();
    }

    public void loadStdImage() throws IOException {
        Image image = ImageIO.read(this.getClass().getResource("/ScreenShot005.png"));
    }

}