import com.googlecode.javacpp.Loader;
    import com.googlecode.javacv.CanvasFrame;
    import static com.googlecode.javacpp.Loader.*;
    import static com.googlecode.javacv.cpp.opencv_core.*;
    import static com.googlecode.javacv.cpp.opencv_highgui.*;
    import static com.googlecode.javacv.cpp.opencv_imgproc.*;
    import java.io.File;
    import javax.swing.JFileChooser;

    public class Ishape {
        public static void main(String[] args) {
            CanvasFrame cnvs=new CanvasFrame("Polygon");
            cnvs.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

            CvMemStorage storage=CvMemStorage.create();
            CvSeq squares = new CvContour();
            squares = cvCreateSeq(0, sizeof(CvContour.class), sizeof(CvSeq.class), storage);
            JFileChooser f=new JFileChooser();
            int result=f.showOpenDialog(f);//show dialog box to choose files
                File myfile=null;
                String path="";
            if(result==0){
                myfile=f.getSelectedFile();//selected file taken to myfile
                path=myfile.getAbsolutePath();//get the path of the file
            }
            IplImage src = cvLoadImage(path);//hear path is actual path to image
            IplImage gry=cvCreateImage(cvGetSize(src),IPL_DEPTH_8U,1);
            cvCvtColor(src, gry, CV_BGR2GRAY);
            cvThreshold(gry, gry, 230, 255, CV_THRESH_BINARY_INV);
            cvFindContours(gry, storage, squares, Loader.sizeof(CvContour.class), CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE);
            CvSeq ss=null;
            for (int i=0; i<1; i++)
            {
                cvDrawContours(gry, squares, CvScalar.WHITE, CV_RGB(248, 18, 18), 1, -1, 8);
                ss=cvApproxPoly(squares, sizeof(CvContour.class), storage, CV_POLY_APPROX_DP, 8, 0);
            }
            IplConvKernel mat=cvCreateStructuringElementEx(7, 7, 3, 3, CV_SHAPE_RECT, null);
            cvDilate(gry, gry, mat, CV_C);
            cvErode(gry, gry, mat, CV_C);
            cnvs.showImage(gry);

        }
    }