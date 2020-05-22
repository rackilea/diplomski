import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;


public class WebCam {
public static void main(String[] args) {
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

VideoCapture videoCapture = new VideoCapture(0);
Mat frame = new Mat();

while (true){
    videoCapture.read(frame);
    showResult(frame);
}
} 

public static void showResult(Mat img) {
Imgproc.resize(img, img, new Size(640, 480));
MatOfByte matOfByte = new MatOfByte();
Highgui.imencode(".jpg", img, matOfByte);
byte[] byteArray = matOfByte.toArray();
BufferedImage bufImage = null;
try {
    InputStream in = new ByteArrayInputStream(byteArray);
    bufImage = ImageIO.read(in);
    JFrame frame = new JFrame();
    frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
    frame.pack();
    frame.setVisible(true);
} catch (Exception e) {
    e.printStackTrace();
}
}
}