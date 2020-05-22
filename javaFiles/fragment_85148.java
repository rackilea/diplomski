import ij.IJ;
import ij.ImagePlus;
import ij.Prefs;

ImagePlus imp = IJ.getImage();
IJ.run(imp, "Find Edges", "stack");
Prefs.blackBackground = true;
IJ.run(imp, "Make Binary", "stack black"); // this line changed
IJ.run(imp, "Erode", "stack");