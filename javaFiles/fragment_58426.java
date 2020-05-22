// LBPHFaceRecognizer.java

import org.opencv.contrib.FaceRecognizer;
import org.opencv.core.Core;


public class LBPHFaceRecognizer extends FaceRecognizer
{
    static{ System.loadLibrary("facerec.dll"); }

    private static native long n_createLBPHFaceRecognizer();

    public LBPHFaceRecognizer()
    {
        super(n_createLBPHFaceRecognizer());
    }
}