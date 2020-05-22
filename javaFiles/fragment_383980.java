import ij.ImagePlus;
import ij.IJ;
import ij.measure.Measurements;
import ij.measure.ResultsTable;
import ij.plugin.filter.Analyzer;

ImagePlus imp = IJ.openImage("http://imagej.nih.gov/ij/images/blobs.gif");
// IJ.setAutoThreshold(imp, "Default");
imp.getProcessor().setAutoThreshold("Default");

// IJ.run("Set Measurements...", "area mean standard modal min median area_fraction limit redirect=None decimal=3");
int measurements = Measurements.AREA + Measurements.MEAN + Measurements.MIN_MAX + Measurements.STD_DEV + Measurements.MODE + Measurements.MEDIAN + Measurements.AREA_FRACTION + Measurements.LIMIT;

// IJ.run(imp, "Measure", "");
ResultsTable rt = new ResultsTable();
Analyzer analyzer = new Analyzer(imp, measurements, rt);
analyzer.measure();

Double result = rt.getValue("Min", rt.getCounter() - 1); // get value of interest
IJ.log(result.toString()); // print to log window
// Alternatively, show the full results table
// rt.show("New Results");