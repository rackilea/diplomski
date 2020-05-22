//step 1
Mat colorEdges;
edgesMat.copyTo(colorEdges);
Imgproc.cvtColor(colorEdges, colorEdges, COLOR_GRAY2BGRA);
//step 2
newColor = new Scalar(0,255,0);    //this will be green
colorEdges.setTo(newColor, edgesMat);
//step 3
colorEdges.copyTo(rgbaInnerWindow, edgesMat);    //this replaces your current cvtColor line, placing your Canny edge lines on the original image