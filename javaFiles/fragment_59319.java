BufferedImage scene = ... ;// The image that you want to test
BufferedImage roi = ... ; //The cropped region of interest selected by your user


int sceneWidth  = scene.getWidth();
int sceneHeight = scene.getHeight();
int roiWidth    = roi.getWidth();
int roiHeight   = roi.getHeight();

int[] histROI = getHistogram(roi);

for (int y=0;y<sceneHeight-roiHeight+1;y++){
    for (int x=0;x<sceneWidth-roiWidth+1;x++){

          BufferedImage sceneROI = cropImage(scene, x,y, roiWidth, roiHeight);
          int[] histSceneROI = getHistogram(sceneROI);

          float comparison  = getRelativeCorrelation(histROI, histSceneROI);

          //todo: something with the comparison.

    }
}