import com.github.sarxos.webcam.Webcam;

public class CameraTest {
    public static void main(String[] args) {
        List<Webcam> list = Webcam.getWebcams();

        for (int i = 0; i < list.size(); i++) {
                try {
                    Webcam cam = list.get(i);
                    System.out.println("Found this Camera : "+cam.getName());
                    BufferedImage image = cam.getImage();
                } catch (Exception e) {
                    System.out.println("Exception in cam : " + i);
                }
        }
    }
}