int startFrame = i * fps + offset;
int endFrame = (i + 1) * fps + offset - 1;
// Calculating STD for current window
// First frame (frame 0)
frame = frames.get(startFrame);
Imgproc.cvtColor(frame, bgr, Imgproc.COLOR_YUV2BGR_I420);
// Extract only red channel
Core.extractChannel(bgr, redMat, 2);
redMat.convertTo(mean, CvType.CV_32FC1, 1/255.0);
var = Mat.zeros((int) frameSize.height, (int) frameSize.width, CvType.CV_32FC1);
// Rest of the frames [1:frameRate)
for (int j = startFrame + 1; j <= endFrame; j++) {
    double n = j - startFrame + 1;
    Log.d(TAG, "Current Frame: " + n);
    frame = frames.get(j);
    Imgproc.cvtColor(frame, bgr, Imgproc.COLOR_YUV2BGR_I420);
    Core.extractChannel(bgr, redMat, 2);
    redMat.convertTo(convRedMat, CvType.CV_32FC1, 1/255.0);
    // Calculate the iterative variance and mean for this frame
    // Var(n) = (n-2)/(n-1)*var(n-1) + 1/n*(X(n) - Mean(n-1))^2
    Core.multiply(var, new Scalar((n-2)/(n-1)), var); // (n-2)/(n-1)*var(n-1)
    Core.subtract(convRedMat, mean, temp1); // (X(n) - Mean(n-1))
    Core.multiply(temp1, temp1, temp2); // (X(n) - Mean(n-1))^2
    Core.multiply(temp2, new Scalar(1/n), temp2); // 1/n*(X(n) - Mean(n-1))^2
    Core.add(var, temp2, var); // (n-2)/(n-1)*var(n-1) + 1/n*(X(n) - Mean(n-1))^2
    // Mean(n) = 1/n*(X(n) + (n-1)*Mean(n-1))
    Core.multiply(mean, new Scalar(n-1), temp1); // (n-1)*Mean(n-1)
    Core.add(convRedMat, temp1, temp2); // X(n) - (n-1)*Mean(n-1)
    Core.multiply(temp2, new Scalar(1/n), mean);
}