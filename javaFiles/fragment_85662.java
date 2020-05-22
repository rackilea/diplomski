BufferedImage TestShot = iris.createScreenCapture(new Rectangle(0,0,width,height));
int[] ImgData = null;
TestShot.getRGB(0, 0, width, height, ImgData, 0, 0);
for(int i:ImgData){
    // count or something
}
// all of it is there in TestShot