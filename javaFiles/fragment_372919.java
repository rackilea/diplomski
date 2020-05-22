import ij.ImagePlus;
import ij.process.ImageConverter;

// ...

ImagePlus imp = IJ.getImage();
ImageConverter ic = new ImageConverter(imp);
ic.convertToGray8();
imp.updateAndDraw();