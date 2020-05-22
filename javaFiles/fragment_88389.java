//all the imports
public class App {
static {
    String path = null;
    try {
        //I have copied dlls from opencv folder to my project folder
        path = "E:\\JAVA Projects\\OpenCv\\RTSP Example\\libraries";
        System.load(path+"\\opencv_java310.dll");
        System.load(path+"\\opencv_ffmpeg310_64.dll");
    } catch (UnsatisfiedLinkError e) {
        System.out.println("Error loading libs");
    }
}

public static void main(String[] args) {

    App app = new App();
    //Address can be different. Check your cameras manual. :554 a standard RTSP port for cameras but it can be different
    String addressString = "rtsp://login:password@192.168.1.14:554/cam/realmonitor?channel=11&subtype=0";
    Mat mat = new Mat();
    VideoCapture capturedVideo = new VideoCapture();

    boolean isOpened = capturedVideo.open(addressString); 
    app.openRTSP(isOpened, capturedVideo, mat);

}

public void openRTSP(boolean isOpened, VideoCapture capturedVideo, Mat cameraMat) {
    if (isOpened) {
        boolean tempBool = capturedVideo.read(cameraMat);
        System.out.println("VideoCapture returned mat? "+tempBool);

        if (!cameraMat.empty()) {
            System.out.println("Print image size: "+cameraMat.size());
            //processing image captured in cameraMat object

        } else {
            System.out.println("Mat is empty.");
        }
    } else {
        System.out.println("Camera connection problem. Check addressString");
    }
}
}