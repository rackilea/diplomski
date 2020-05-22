ImgTransformation.adjustConvertColor(tempMat,tempMat,Imgproc.COLOR_BGR2GRAY);

Imgproc.adaptiveThreshold(tempMat,tempMat,255,Imgproc.ADAPTIVE_THRESH_MEAN_C,Imgproc.THRESH_BINARY,31,40);

ImgTransformation.gaussianBlur(tempMat,tempMat,5,5,2);
Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*1 + 1, 2*1+1));
Imgproc.dilate(tempMat,tempMat,element);
Imgproc.erode(tempMat,tempMat,element);
ImgTransformation.adjustBinary(tempMat,tempMat,205,255,Imgproc.THRESH_BINARY_INV);