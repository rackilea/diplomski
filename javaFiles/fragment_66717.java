int whichDescriptor = siftDescriptor; //freakDescriptor;

        // Features SEARCH
        int detectorType = FeatureDetector.SIFT;
        FeatureDetector detector = FeatureDetector.create(detectorType);

        Mat mask = new Mat();
        MatOfKeyPoint keypoints = new MatOfKeyPoint();
        detector.detect(image, keypoints , mask);               

        if (!detector.empty()){

            // Draw kewpoints
            Mat outputImage = new Mat();
            Scalar color = new Scalar(0, 0, 255); // BGR
            int flags = Features2d.DRAW_RICH_KEYPOINTS; // For each keypoint, the circle around keypoint with keypoint size and orientation will be drawn.
            Features2d.drawKeypoints(image, keypoints, outputImage, color , flags); 
            displayImage(Mat2BufferedImage(outputImage), "Feautures_"+detectorType);
        }