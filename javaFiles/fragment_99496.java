...
Point r2 = new Point(width/2+width/10, height/2+height/10);
Scalar color = new Scalar(1);

Core.rectangle(maskMat, r1, r2, color, Core.FILLED);

Imgproc.cvtColor(viewMat, outMat, Imgproc.COLOR_RGBA2RGB);

Photo.inpaint(outMat, maskMat, outMat, 1, Photo.INPAINT_TELEA);
...