private void updateDeviceImage(Shell paramShell, RawImage paramRawImage)
{
PaletteData localPaletteData = new PaletteData(paramRawImage.getRedMask(), paramRawImage.getGreenMask(), paramRawImage.getBlueMask());

ImageData localImageData = null;
localImageData = new ImageData(paramRawImage.width, paramRawImage.height, paramRawImage.bpp, localPaletteData, 1, paramRawImage.data);

try { 
Image localImage = new Image(paramShell.getDisplay(), localImageData);

if (this.mRotateImage) { 

    localImage = resize(localImage,heightImage * percentSize/100 ,widthImage * percentSize/100);
} else { 
    localImage = resize(localImage,widthImage * percentSize/100,heightImage * percentSize/100);
}
this.mImageLabel.setImage(localImage);
this.mImageLabel.pack();
paramShell.pack();
} catch (Exception e) {
    String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
    //System.out.print(e.toString());
    System.out.print(fullStackTrace);
    //
} 
}