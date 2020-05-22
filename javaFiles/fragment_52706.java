package com.datroop.histogram;

import java.awt.image.renderable.ParameterBlock;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.media.jai.Histogram;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.ROI;
import javax.media.jai.RenderedOp;

public class HistogramCreator {

private HistogramCreator() {        
}

public static int[] createHistogram(final PlanarImage image) {
    // set up the histogram
    final int[] bins = { 256 };
    final double[] low = { 0.0D };
    final double[] high = { 256.0D };

    Histogram histogram = new Histogram(bins, low, high);

    final ParameterBlock pb = new ParameterBlock();

    pb.addSource(image);
    pb.add(null);
    pb.add(1);
    pb.add(1);

    final RenderedOp op = JAI.create("histogram", pb);
    histogram = (Histogram) op.getProperty("histogram");

    // get histogram contents
    final int[] local_array = new int[histogram.getNumBins(0)];

    for (int i = 0; i < histogram.getNumBins(0); i++) {
        local_array[i] = histogram.getBinSize(0, i);
    }

    return local_array;
}

public static void main(String[] args) {
    try {
        String filename = "file://localhost/C:/myimage.jpg";
        System.setProperty("com.sun.media.jai.disableMediaLib", "true");
        // Create the histogram
        int[] myHistogram = createHistogram(JAI.create("url", new URL(filename)));
        // Check it out here
        System.out.println(Arrays.toString(myHistogram));
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
}