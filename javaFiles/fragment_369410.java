myFeatures = FeatureDetector.create(FeatureDetector.FAST);
rgb = new Mat();
outputImage = new Mat();
keypoints = new MatOfKeyPoint();

Imgproc.cvtColor(inputImage, rgb, Imgproc.COLOR_RGBA2RGB);
myFeatures.detect(rgb, keypoints);
Features2d.drawKeypoints(rgb, keypoints, rgb);
Imgproc.cvtColor(rgb, outputImage, Imgproc.COLOR_RGB2RGBA);