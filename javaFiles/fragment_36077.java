facerec = new createFisherFaceRecognizer(); 
    // traindata
    List<Mat> traindata = new ArrayList<Mat>();
    traindata.add(image1);    // add grayscale images, all cropped to the same size (like(90x90)
    traindata.add(image2);    // ...

    // trainlabels, i guess, MatOfInt(1,2,3) would work, too
    Mat labels = new Mat(1,traindata.size(), CvType.CV_32S);
    int [] l = {1,2,3, ... }; // 1 label for each image
    labels.put(0, 0, l);
    facerec.train( traindata, labels );

    // now to prediction:
    int [] label = new int[1];
    double [] conf = new double[1];
    // test_im must be grayscale, cropped to same size as the trainimages
    facerec.predict(test_im, label, conf); 
    System.out.println("rec " + label[0] + " " + conf[0]);