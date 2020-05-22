import com.googlecode.javacpp.Loader;
    import com.googlecode.javacv.CanvasFrame;
    import static com.googlecode.javacpp.Loader.*;
    import static com.googlecode.javacv.cpp.opencv_core.*;
    import static com.googlecode.javacv.cpp.opencv_highgui.*;
    import static com.googlecode.javacv.cpp.opencv_imgproc.*;

    public class Test {
        public static void main(String[] args) {
            CvMemStorage storage=CvMemStorage.create();
            CvSeq squares = new CvContour();
            squares = cvCreateSeq(0, sizeof(CvContour.class), sizeof(CvSeq.class), storage);
            String path="C:/Users/Smash/Desktop/A.PNG";
            IplImage src = cvLoadImage(path);//hear path is actual path to image
            IplImage gry=cvCreateImage(cvGetSize(src),IPL_DEPTH_8U,1);
            cvCvtColor(src, gry, CV_BGR2GRAY);
            cvFindContours(gry, storage, squares, Loader.sizeof(CvContour.class), CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE);
            CvSeq ss=null;
            for (int i=0; i<1; i++)
            {
                cvDrawContours(gry, squares, CvScalar.WHITE, CV_RGB(248, 18, 18), 1, -1, 8);
                ss=cvApproxPoly(squares, sizeof(CvContour.class), storage, CV_POLY_APPROX_DP, 8, 0);
            }
            if(!ss.isNull()){
                drawPoly(src, ss);
            }
        }
        public static void drawPoly( IplImage image, final CvSeq Poly )
        {
            CvSeq rslt=cvApproxPoly(Poly, Loader.sizeof(CvContour.class), cvCreateMemStorage(0), CV_POLY_APPROX_DP, cvContourPerimeter(Poly)*0.02, 0);
            System.out.println(rslt.total());
            for(int i = 0; i < rslt.total(); i++){
                    CvPoint v=new CvPoint(cvGetSeqElem(rslt, i));
                    cvDrawCircle(image, v, 5, CvScalar.BLUE, -1, 8, 0);
                    System.out.println(" X value = "+v.x()+" ; Y value ="+v.y());
            }
            final CanvasFrame canvas = new CanvasFrame("Point Identify");
            canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            canvas.showImage(image);
        }
    }