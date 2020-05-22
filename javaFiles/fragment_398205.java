// dataset
    dataset = new HistogramDataset();
    final int w = image.getWidth();
    final int h = image.getHeight();
    double[] buffer = new double[w * h];
    double[] rgb;

    buffer = raster.getSamples(0, 0, w, h, 0, buffer);
    rgb = Arrays.copyOf(buffer, buffer.length * 3); // copy as otherwise it gets overwritten in next getSamples
    dataset.addSeries(lang.getString("HistogramRGB.String.red"), buffer, BINS);

    buffer = raster.getSamples(0, 0, w, h, 1, buffer);
    System.arraycopy(buffer, 0, rgb, buffer.length, buffer.length); //Add G
    dataset.addSeries(lang.getString("HistogramRGB.String.green"), buffer, BINS);

    buffer = raster.getSamples(0, 0, w, h, 2, buffer);
    System.arraycopy(buffer, 0, rgb, buffer.length * 2, buffer.length); //Add B
    dataset.addSeries(lang.getString("HistogramRGB.String.blue"), buffer, BINS);

    dataset.addSeries(lang.getString("HistogramRGB.String.brigthness"), rgb, BINS);

    // chart
    chart = ChartFactory.createHistogram(lang.getString("HistogramRGB.String.histogram"), "", "", dataset,
            PlotOrientation.VERTICAL, false, true, false);