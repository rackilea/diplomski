ArrayList<Point> pointsInterestList = new ArrayList<Point>();

    for (int j = 0; j < mask.rows(); j++) {
        for (int k = 0; k < mask.cols(); k++) {
            double[] pixel = mask.get(j, k);

            if (pixel[0] == 255) {
                //add Point of Mat to list of points
                Point point = new Point(k, j);
                pointsInterestList.add(point);
            }
        }
    }

    // System.out.println("PointsInteresedList: "+pointsInterestList);

    MatOfPoint2f m2fFromList = new MatOfPoint2f();
    m2fFromList.fromList(pointsInterestList); //create MatOfPoint2f from list of points
    MatOfPoint2f m2f = new MatOfPoint2f();
    m2fFromList.convertTo(m2f, CvType.CV_32FC2); //convert to type of MatOfPoint2f created from list of points


    RotatedRect minRect = Imgproc.minAreaRect(m2f);