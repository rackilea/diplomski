@Override
public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
    mrgba = inputFrame.rgba();
    Imgproc.circle (
            mrgba,                 //Matrix obj of the image
            new Point(mrgba.width() * 0.5,mrgba.height() * 0.5),    //Center of the circle
            10,                    //Radius
            new Scalar(0, 0, 255),  //Scalar object for color
            10                     //Thickness of the circle
    );

    return mrgba;
}