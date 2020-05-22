long firstImageSize = getImageSize(0); //get the size of the first image in bytes
long startTime = System.currentTimeMillis();
UploadFirstImage();  //Upload the first image
long stopTime = System.currentTimeMillis();
long elapsedTime = stopTime - startTime;
float meanSpeed = (float)firstImageSize/ (float)(elapsedTime / 1000);  //mean speed in bytes/second