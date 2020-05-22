import ij.IJ;

imp = IJ.openImage("http://imagej.nih.gov/ij/images/blobs.gif");
IJ.setAutoThreshold(imp, "Default");
IJ.run("Set Measurements...", "area mean standard modal min median area_fraction limit redirect=None decimal=3");
IJ.run(imp, "Measure", "");
imp.show();