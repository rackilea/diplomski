public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
    // The object's width and height are set to 0
    List<Integer> objectWidth = new ArrayList<>();
    List<Integer> objectHeight = new ArrayList<>();

    // frame is captured as a coloured image
    Mat frame = inputFrame.rgba();
    Mat gray = new Mat();
    Mat canny = new Mat();
    List<MatOfPoint> contours = new ArrayList<>();

    /** Since the Canny algorithm only works on greyscale images and the captured image is
     *  coloured, we transform the captured cam image into a greyscale one
     */
    Imgproc.cvtColor(frame, gray, Imgproc.COLOR_RGB2GRAY);

    // Calculating borders of image using the Canny algorithm
    Imgproc.Canny(gray, canny, 180, 210);

    /** To avoid background noise (given by the camera) that makes the system too sensitive
     *  small variations, the image is blurred to a small extent. Blurring is one of the
     *  required steps before any image transformation because this eliminates small details
     *  that are of no use. Blur is a low-pass filter.
     */
    Imgproc.GaussianBlur(canny, canny, new Size(5, 5), 5);

    // Calculate the contours
    Imgproc.findContours(canny, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

    /** The contours come in different sequences
     *  1 sequence for each connected component.
     *  Taking the assumption only 1 object is in view, if we have more than 1 connected
     *  component, this'll be considered part of the details of the object.
     *
     *  For this, we put all contours together in a single sequence
     *  If there is at least 1 contour, I can continue processing
     */

    if(contours.size() > 0){
        // Calculating the minimal rectangle to contain the contours
        List<RotatedRect> boxes = new ArrayList<>();
        for(MatOfPoint contour : contours){
            RotatedRect box = Imgproc.minAreaRect(new MatOfPoint2f(contour.toArray()));
            boxes.add(box);
        }

        // Getting the vertices of the rectangle

        List<Point[]> vertices = initialiseWithDefaultPointInstances(boxes.size(), 4);
        for(int i=0; i<boxes.size(); i++){
            boxes.get(i).points(vertices.get(i));
        }

        /*
        double alpha = 0.5;
        // Now the vertices are in possession, temporal smoothing can be performed.
            for(int i = 0; i<vertices.size(); i++){
                for (int j = 0; j < 4; j++) {
                    // Smooth coordinate x of the vertex
                    vertices.get(i)[j].x = alpha * lastVertices.get(i)[j].x + (1.0 - alpha) * vertices.get(i)[j].x;
                    // Smooth coordinate y of the vertex
                    vertices.get(i)[j].y = alpha * lastVertices.get(i)[j].y + (1.0 - alpha) * vertices.get(i)[j].y;
                    // Assign the present smoothed values as lastVertices for the next smooth
                    lastVertices.get(i)[j] = vertices.get(i)[j];
                }
        }*/

        /** With the vertices, the object size is calculated.
         *  The object size is calculated through pythagoras theorm. In addition, it gives
         *  the distance between 2 points in a bi-dimensional space.
         *
         *  For a rectangle, considering any vertex V, its two sizes (width and height) can
         *  be calculated by calculating the distance of V from the previous vertex and
         *  calculating the distance of V from the next vertex. This is the reason why I
         *  calculate the distance between vertici[0]/vertici[3] and vertici[0]/vertici[1]
         */
        double conversionFactor = 1.0;
        for(Point[] points : vertices){
            int width = (int) (conversionFactor * Math.sqrt((points[0].x - points[3].x) * (points[0].x - points[3].x) + (points[0].y - points[3].y) * (points[0].y - points[3].y)));
            int height = (int) (conversionFactor * Math.sqrt((points[0].x - points[1].x) * (points[0].x - points[1].x) + (points[0].y - points[1].y) * (points[0].y - points[1].y)));
            objectWidth.add(width);
            objectHeight.add(height);
        }



        /** Draw the rectangle containing the contours. The line method draws a line from 1
         *  point to the next, and accepts only integer coordinates; for this reason, 2
         *  temporary Points have been created and why I used Math.round method.
         */
        Scalar red = new Scalar(255, 0, 0, 255);
        for (int i=0; i<vertices.size(); i++){
            Point pt1 = new Point();
            Point pt2 = new Point();
            for (int j = 0; j < 4; j++) {
                pt1.x = Math.round(vertices.get(i)[j].x);
                pt1.y = Math.round(vertices.get(i)[j].y);
                pt2.x = Math.round(vertices.get(i)[(j + 1) % 4].x);
                pt2.y = Math.round(vertices.get(i)[(j + 1) % 4].y);
                Imgproc.line(frame, pt1, pt2, red, 3);
            }
            if (objectWidth.get(i) != 0 && objectHeight.get(i) != 0){
                Imgproc.putText(frame, "width: " + objectWidth + ", height: " + objectHeight, new Point(Math.round(vertices.get(i)[1].x), Math.round(vertices.get(i)[1].y)), 1, 1, red);
            }
        }

    }


    // This function must return
    return frame;
}

// Initialising an array of points
public static List<Point[]> initialiseWithDefaultPointInstances(int n_Contours, int n_Points) {
    List<Point[]> pointsList = new ArrayList<>();
    for(int i=0; i<n_Contours; i++){
        Point[] array = new Point[n_Points];
        for (int j = 0; j < n_Points; j++) {
            array[j] = new Point();
        }
        pointsList.add(array);
    }
    return pointsList;
}