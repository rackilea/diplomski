if (points != null) {
        Point p1 = points[0];
        Point p2 = points[1];
        Point p3 = points[2];
        Point p4 = points[3];

        MatOfPoint2f src = new MatOfPoint2f(
                p1,
                p2,
                p3,
                p4);

        drawMarker(frame, p1, new Scalar(255,0,0), 0, 20, 1);
        drawMarker(frame, p2, new Scalar(255,0,0), 0, 20, 1);
        drawMarker(frame, p3, new Scalar(255,0,0), 0, 20, 1);
        drawMarker(frame, p4, new Scalar(255,0,0), 0, 20, 1);

        double x = p2.x - p1.x;
        double y = p3.y - p2.y;

        MatOfPoint2f dst = new MatOfPoint2f(
                new Point(0, 0),
                new Point(x,0),
                new Point(0,y),
                new Point(x,y)
        );

        Mat warpMat = Imgproc.getPerspectiveTransform(src, dst);
        //This is you new image as Mat
        Mat destImage = new Mat();
        Imgproc.warpPerspective(bw2, destImage, warpMat, new Size(x, y));

        List<Mat> cells = getCells(destImage, destImage.width() / 9, destImage.height / 9);


    }



private List<Mat> getCells(Mat m, int width, int height) {

    Size cellSize = new Size(width, height);
    List<Mat> cells = new ArrayList<>();

    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            Rect rect = new Rect(new Point(col * width, row * height), cellSize);

            Mat digit = new Mat(m, rect).clone();
            cells.add(digit);
        }
    }

    return cells;
}