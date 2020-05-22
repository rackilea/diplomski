public class Main {
   public static void main( String[] args ) {
       System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

       Mat bgr = Highgui.imread("H:/Development/workspace/label.png");
       Mat hsv = new Mat();
       Imgproc.cvtColor(bgr, hsv, Imgproc.COLOR_RGB2HSV);
       Highgui.imwrite("H:/Development/workspace/label_hsv.png");
   }
}