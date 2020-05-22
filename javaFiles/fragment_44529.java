Mat finalMat = new Mat();
Mat tempMat = new Mat();
Utils.bitmapToMat(bmps.get(0), finalMat);
for (int i = 1; i < bmps.size(); i++) {
    Utils.bitmapToMat(bmps.get(i), tempMat);
    if (tempMat.cols() == finalMat.cols()){
        Core.vconcat(finalMat, tempMat, finalMat);
    }
    else{
    Log.d("debug", "The matrices don't have equal dimensions");
    }
}